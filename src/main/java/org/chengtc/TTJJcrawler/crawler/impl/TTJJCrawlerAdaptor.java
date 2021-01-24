package org.chengtc.TTJJcrawler.crawler.impl;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.StringUtils;
import org.chengtc.TTJJcrawler.crawler.ICrawlerAdaptor;
import org.chengtc.TTJJcrawler.dto.FundBaseInfoDto;
import org.chengtc.TTJJcrawler.service.WebClientService;
import org.chengtc.TTJJcrawler.utils.DateUtils;
import org.chengtc.TTJJcrawler.utils.JsoupUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * @name: TTJJCrawlerAdaptor
 * @description: 功能描述 - TTJJCrawlerAdaptor --
 * @author: chengtianci
 * @date: 2021/1/20 下午2:30
 */
@Component
public class TTJJCrawlerAdaptor implements ICrawlerAdaptor {

    @Autowired
    WebClientService webClientService;
    private final String base_url = "http://fund.eastmoney.com/data/fundsearch.html?";


    @Override
    public Document processs(Map<String, String> keyWord) {
        if (null==keyWord){
            keyWord = new HashMap<>();
        }
        String parameters = JsoupUtils.fetchParams(keyWord);
        Document document = null;
        HtmlPage page = null;
        try {
            page = webClientService.getWebClient().getPage(base_url + parameters);
            webClientService.getWebClient().waitForBackgroundJavaScript(30000);//异步JS执行需要耗时,所以这里线程要阻塞30秒,等待异步JS执行结束
            DomElement targetLink = page.getElementById("jj").getLastElementChild().getFirstElementChild();
            HtmlPage page2=targetLink.click();
            String pageXml = page2.asXml();//直接将加载完成的页面转换成xml格式的字符串
            document = Jsoup.parse(pageXml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public List<FundBaseInfoDto> prase(Document document) throws IOException, ParseException {
        List<FundBaseInfoDto> fundList=new ArrayList<>();
        Elements trs= document.getElementById("jj").getElementsByTag("tr");
        int len = trs.size();
        for(int i=1;i<len;i++){
            fundList.add(praseFileds(trs.get(i)));
        }
        return fundList;
    }

    private FundBaseInfoDto praseFileds(Element element) throws IOException, ParseException {

        if (element.getElementsByTag("td").isEmpty()){return null;}
        String href = element.getElementsByTag("td").get(0).getElementsByTag("a").attr("href");
        if (StringUtils.isEmpty(href)){return null;}
        HtmlPage page = webClientService.getWebClientJs().getPage(href);
        HtmlElement documentElement = page.getDocumentElement();
        List<HtmlElement> elementsByAttribute = documentElement.getElementsByAttribute("div", "class", "infoOfFund");
        List<HtmlElement> divs = documentElement.getElementsByAttribute("div", "style", "float: left");
        if (divs.isEmpty()){return null;}
        DomNodeList<HtmlElement> tds = elementsByAttribute.get(0).getElementsByTagName("td");
        String[] split = divs.get(0).getTextContent().split("\\(");
        if (tds.size()<1){return null;}
        String fundType = tds.get(0).getTextContent().split("：")[1];
        if (tds.size()<2){return null;}
        String fundAmont = tds.get(1).getTextContent().split("：")[1].split("亿")[0];
        if (tds.size()<4){return null;}
        String establishYear = tds.get(3).getTextContent().split("：")[1];
//        String duringYear = String.valueOf(DateUtils.yearsBetweenNow(establishYear));
        if (tds.size()<7){return null;}
        String trackingError = tds.get(6).getTextContent().split("\\|")[1].split("：")[1];
        return FundBaseInfoDto.builder()
                .name(split[0])
                .code(split[1])
                .establishYear(establishYear)
//                .establishDuringYear(duringYear)
                .trackingError(trackingError)
                .transactionMode(fundType)
                .scale(fundAmont)
                .build();
    }
}

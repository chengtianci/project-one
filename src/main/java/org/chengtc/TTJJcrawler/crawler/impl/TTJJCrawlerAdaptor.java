package org.chengtc.TTJJcrawler.crawler.impl;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.StringUtils;
import org.chengtc.TTJJcrawler.crawler.ICrawlerAdaptor;
import org.chengtc.TTJJcrawler.service.WebClientService;
import org.chengtc.TTJJcrawler.utils.JsoupUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
            String pageXml = page.asXml();//直接将加载完成的页面转换成xml格式的字符串
            document = Jsoup.parse(pageXml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public void prase(Document document) {

    }



}

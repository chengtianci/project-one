package org.chengtc.TTJJcrawler.crawler;

import org.chengtc.TTJJcrawler.dto.FundBaseInfoDto;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @name: ICrawler
 * @description: 功能描述 - ICrawler --
 * @author: chengtianci
 * @date: 2021/1/19 下午2:58
 */
public interface ICrawlerAdaptor {

    /**
     * @title processs
     * @param
     * @return void
     * @author ctc2811
     * @describe: 处理获取网址的网页元素
     * @date 2021/1/19 下午3:08
     */
    Document processs(Map<String, String> keyWord);

    /**
     * @title prase
     * @param
     * @return List<FundBaseInfoDto>
     * @author ctc2811
     * @describe: 解析网页元素获取所需的数据
     * @date 2021/1/19 下午3:12
     */
    List<FundBaseInfoDto> prase(Document document) throws IOException, ParseException;
}

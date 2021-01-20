package org.chengtc.TTJJcrawler.crawler;

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
    public void processs();

    /**
     * @title prase
     * @param
     * @return void
     * @author ctc2811
     * @describe: 解析网页元素获取所需的数据
     * @date 2021/1/19 下午3:12
     */
    public void prase();
}

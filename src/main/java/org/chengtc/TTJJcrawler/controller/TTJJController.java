package org.chengtc.TTJJcrawler.controller;

import org.chengtc.TTJJcrawler.crawler.impl.TTJJCrawlerAdaptor;
import org.chengtc.TTJJcrawler.utils.JsonResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @name: TTJJController
 * @description: 功能描述 - TTJJController --
 * @author: chengtianci
 * @date: 2021/1/20 上午11:13
 */
@RestController
public class TTJJController {
    @Autowired
    TTJJCrawlerAdaptor ttjjCrawlerAdaptor;
    /**
     * @title excel
     * @param
     * @return org.chengtc.TTJJcrawler.utils.JsonResult
     * @author ctc2811
     * @describe:
     * @date 2021/1/20 下午2:23
     */
    @GetMapping("excel")
    public JsonResult excel(@RequestParam("key")String key) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        map.put("spm","search");
        map.put("key",key);
        Document doc = ttjjCrawlerAdaptor.processs(map);
        System.out.println(doc);
        return JsonResult.success();
    }

}

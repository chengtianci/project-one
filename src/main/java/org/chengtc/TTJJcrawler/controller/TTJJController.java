package org.chengtc.TTJJcrawler.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.chengtc.TTJJcrawler.crawler.impl.TTJJCrawlerAdaptor;
import org.chengtc.TTJJcrawler.dto.FundBaseInfoDto;
import org.chengtc.TTJJcrawler.utils.FileUtils;
import org.chengtc.TTJJcrawler.utils.JsonResult;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;


/**
 * @name: TTJJController
 * @description: 功能描述 - TTJJController --
 * @author: chengtianci
 * @date: 2021/1/20 上午11:13
 */
@RestController("/ttjj")
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
    @GetMapping("/excel")
    public JsonResult excel(@RequestParam("key")String key) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        map.put("spm","search");
        map.put("key",key);
        Document doc = ttjjCrawlerAdaptor.processs(map);
        FileUtils.wirteHtml("first",doc.toString());
        List<FundBaseInfoDto> dataList = ttjjCrawlerAdaptor.prase(doc);
        EasyExcel.write(key+"."+ExcelTypeEnum.XLSX, FundBaseInfoDto.class).sheet(key+"."+ExcelTypeEnum.XLSX).doWrite(dataList);
        return JsonResult.success();
    }

}

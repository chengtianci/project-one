package org.chengtc.TTJJcrawler.service;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @name: WebClientService
 * @description: 功能描述 - WebClientService --
 * @author: chengtianci
 * @date: 2021/1/20 下午4:36
 */
@Data
@Component
public class WebClientService {
    private WebClient webClient = null;
    private WebClient webClientJs = null;

    WebClientService(){
        webClient = new WebClient(BrowserVersion.CHROME);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象
        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setActiveXNative(false);//不启用ActiveX
        webClient.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setJavaScriptEnabled(true); //很重要，启用JS
        webClient.getOptions().setDownloadImages(false);//不下载图片
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
        webClientJs = new WebClient(BrowserVersion.CHROME);//新建一个模拟谷歌Chrome浏览器的浏览器客户端对象
        webClientJs.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClientJs.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClientJs.getOptions().setActiveXNative(false);//不启用ActiveX
        webClientJs.getOptions().setCssEnabled(false);//是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClientJs.getOptions().setJavaScriptEnabled(false); //很重要，启用JS
        webClientJs.getOptions().setDownloadImages(false);//不下载图片
        webClientJs.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX
    }
}

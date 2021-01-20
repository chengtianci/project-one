package org.chengtc.TTJJcrawler.utils;

import java.util.Map;

/**
 * @name: JsoupUtils
 * @description: 功能描述 - JsoupUtils --
 * @author: chengtianci
 * @date: 2021/1/19 下午3:13
 */
public class JsoupUtils {
    public static String fetchParams(Map<String, String> keymap){
        StringBuilder sb = new StringBuilder();
        for(String key : keymap.keySet()){
            String value = keymap.get(key);
            System.out.println(key+"  "+value);
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        return sb.toString();
    }
}

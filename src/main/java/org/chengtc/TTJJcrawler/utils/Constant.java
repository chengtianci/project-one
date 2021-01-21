package org.chengtc.TTJJcrawler.utils;

import okhttp3.MediaType;

/**
 * @author 项健健
 * @time 2021/1/21
 * @comment
 */

public class Constant {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static final String PREFIX = "{'User_id':'1','CmdList':[{'CmdName':'Assembly','CmdPartList':[{'CmdPartName':'AssemblyString'," +
            "'CmdPartValue':'SyncPurchase','Remark':'程序集名称'},{'CmdPartName':'ClassName','CmdPartValue':'CommonWeb','Remark':'类名称'}," +
            "{'CmdPartName':'MethodName','CmdPartValue':'getReserveAM','Remark':'方法名称'},{'CmdPartName':'AmMeter_ID','CmdPartValue':'";

    public static final String SUFFIX = "'}],'CmdValue':''}]}";

    public static final String QUERY_URL = "http://211.69.132.126:8088/BaseInfo.ashx";

    public static final String MSG_URL = "http://wxpusher.zjiecode.com/api/send/message";
}

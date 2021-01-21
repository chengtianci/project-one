package org.chengtc.TTJJcrawler.service;

import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.chengtc.TTJJcrawler.utils.Constant;
import org.chengtc.TTJJcrawler.utils.Message;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

/**
 * @author 项健健
 * @time 2021/1/21
 * @comment
 */


public class NotifyServiceTester {

    private final OkHttpClient client = new OkHttpClient();

    public void sendMsg(String summary, String content) {
        Message message = new Message();
        message.setAppToken("token here");
        message.setSummary(summary);
        message.setContent(content);
        message.setContentType(2);
        message.setTopicIds(new Integer[]{1427});
        RequestBody body = RequestBody.create(JSON.toJSONString(message), Constant.JSON);
        Request request = new Request.Builder()
                .url(Constant.MSG_URL)
                .post(body)
                .build();
        try {
            String result = Objects.requireNonNull(client.newCall(request).execute().body()).string();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test () {
        sendMsg("测试html", "<table border=\"1\">\n" +
                "    <tr>\n" +
                "        <td>row 1, cell 1</td>\n" +
                "        <td>row 1, cell 2</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>row 2, cell 1</td>\n" +
                "        <td>row 2, cell 2</td>\n" +
                "    </tr>\n" +
                "</table>");
    }
}

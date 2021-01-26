package org.chengtc.TTJJcrawler.service;

import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.chengtc.TTJJcrawler.utils.Constant;
import org.chengtc.TTJJcrawler.utils.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

/**
 * @author 项健健
 * @time 2021/1/21
 * @comment
 */

@Service
public class NotifyService {

    private final OkHttpClient client;

    @Value("${custom.token}")
    private String token;

    public NotifyService() {
        client = new OkHttpClient();
    }

    /**
     * 推送微信
     *
     * @param summary 标题
     * @param content 内容
     *                contentType:
     *                1 文字
     *                2 Html
     *                3 Markdown
     */

    public void sendMsg(String summary, String content) {
        Message message = new Message();
        message.setAppToken(token);
        message.setSummary(summary);
        message.setContent(content);
        message.setContentType(1);
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

}

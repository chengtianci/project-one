package org.chengtc.TTJJcrawler.utils;

import lombok.Data;

/**
 * @author 项健健
 * @time 2021/1/21
 * @comment
 */

@Data
public class Message {

    private String appToken;

    private String content;

    private String summary;

    private Integer contentType;

    private Integer[] topicIds;

    private Integer[] uids;

    private String url;

}

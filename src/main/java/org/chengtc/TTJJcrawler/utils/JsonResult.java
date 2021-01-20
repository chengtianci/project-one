package org.chengtc.TTJJcrawler.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @name: JsonResult
 * @description: 功能描述 - JsonResult --
 * @author: chengtianci
 * @date: 2021/1/20 上午11:14
 */
@Data
@AllArgsConstructor
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -6969303460641518534L;

    public static final int CODE_SUCCESS = 0;
    public static final String MSG_SUCCESS = "操作成功";
    public static final int CODE_FAIL = -1;
    public static final String MSG_FAIL = "操作失败";
    public static final String NOOP = "";


    private int code ;
    private String msg;
    private T data;
    /**
     * @title success
     * @param
     * @return org.chengtc.TTJJcrawler.utils.JsonResult
     * @author ctc2811
     * @describe: 处理成功
     * @date 2021/1/20 下午2:20
     */
    public static final JsonResult success(){return new JsonResult(CODE_SUCCESS,MSG_SUCCESS,NOOP);}
    public static final JsonResult success(Object data){return new JsonResult(CODE_SUCCESS,MSG_SUCCESS,data);}
    public static final JsonResult success(String msg,Object data){return new JsonResult(CODE_SUCCESS,msg,data);}
    /**
     * @title fail
     * @param
     * @return org.chengtc.TTJJcrawler.utils.JsonResult
     * @author ctc2811
     * @describe: 处理失败
     * @date 2021/1/20 下午2:22
     */
    public static final JsonResult fail(){return new JsonResult(CODE_FAIL,MSG_FAIL,NOOP);}
    public static final JsonResult fail(Object data){return new JsonResult(CODE_FAIL,MSG_FAIL,data);}
    public static final JsonResult fail(String msg,Object data){return new JsonResult(CODE_FAIL,msg,data);}
}

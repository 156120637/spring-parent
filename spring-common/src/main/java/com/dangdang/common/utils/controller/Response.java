package com.dangdang.common.utils.controller;

import lombok.Data;

/**
 * web返回结果集
 */
@Data
public class Response {

    /**
     * 返回结果 0：成功，1 失败
     */
    private int errorCode;
    /**
     * 状态码 0; 1; 2; 3;
     */
    private int statusCode;
    /**
     * 状态码 0 请求成功; 1 参数错误; 2:系统错误;
     */
    private String statusMsg;
    /**
     * 接口耗时
     */
    private long costTime;
    
    private Object data;

}

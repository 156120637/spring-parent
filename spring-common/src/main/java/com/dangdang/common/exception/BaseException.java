package com.dangdang.common.exception;

import java.io.Serializable;

/**
 * @Author: wyg
 * @Date: 2018/4/4 上午11:07
 * @Description:
 */
public class BaseException extends Exception implements Serializable {

    private Integer code;

    private String message;

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}

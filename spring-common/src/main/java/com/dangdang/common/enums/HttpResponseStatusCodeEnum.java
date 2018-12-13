package com.dangdang.common.enums;

/**
 * Create by tianjiaqin 2018-12-13
 */
public enum HttpResponseStatusCodeEnum {

    HTTP_STATUS_CODE_SUCCESS(0, "成功"),
    HTTP_STATUS_CODE_FAIL(1, "失败"),
    HTTP_STATUS_CODE_PARAMETER(2,"参数错误"),
    HTTP_STATUS_CODE_SYSTEM(3,"系统错误");



    private Integer type;
    private String name;


    private HttpResponseStatusCodeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
    public Integer getType() {
        return type;
    }
    public String getDesc() {
        return name;
    }


}

package com.dangdang.common.enums;

/**
 * Create by tianjiaqin 2018-12-13
 */
public enum HttpResponseErrorCodeEnum {

    /**
     * 响应结果： 0 成功 1 失败
     */
    HTTP_ERROR_CODE_SUCCESS(0, "成功"),
    HTTP_ERROR_CODE_FAIL(1, "失败");
    private Integer type;
    private String name;
    private HttpResponseErrorCodeEnum(Integer type, String name) {
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

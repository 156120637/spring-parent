package com.dangdang.common.enums;

import lombok.Getter;

/**
 * Create by tianjiaqin 2018/11/12
 */
@Getter
public enum ManagerCodeEnum {

    PRODUCTS_CATEGORY_NOT_EXISTS(2001, "分类[%s]不存在"),
    PRODUCTS_PRODUCT_NOT_EXISTS(2002, "商品[%s]不存在"),

    ;

    private Integer code;
    private String msg;

    ManagerCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

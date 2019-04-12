package com.dangdang.common.utils.page;

/**
 * Create by tianjiaqin 2018/11/12
 */
public interface ParamsFillHandler<O> {

    O handle(O obj);
}
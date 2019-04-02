package com.dangdang.common.utils.page;

/**
 * @Author: wyg
 * @Date: 2018/4/4 上午11:07
 * @Description:
 */
public interface ParamsFillHandler<O> {

    O handle(O obj);
}
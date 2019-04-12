package com.dangdang.common.utils.page;

import com.dangdang.common.exception.BaseException;

/**
 * Create by tianjiaqin 2018/11/12
 */
public interface ParamsCopyHandler<O, N> {

    N handle(O obj) throws BaseException;
}
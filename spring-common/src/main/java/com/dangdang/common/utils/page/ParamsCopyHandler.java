package com.dangdang.common.utils.page;

import com.dangdang.common.exception.BaseException;

/**
 * @Author: wyg
 * @Date: 2018/4/4 上午11:07
 * @Description:
 */
public interface ParamsCopyHandler<O, N> {

    N handle(O obj) throws BaseException;
}
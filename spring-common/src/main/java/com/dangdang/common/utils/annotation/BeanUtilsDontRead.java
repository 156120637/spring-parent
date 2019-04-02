package com.dangdang.common.utils.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wyg
 * @Date: 2018/4/4 上午11:07
 * @Description:
 */
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BeanUtilsDontRead {
}
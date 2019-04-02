package com.dangdang.common.utils.annotation;

import java.lang.annotation.*;

/**
 * @Author: wyg
 * @Date: 2018/4/4 上午11:07
 * @Description:
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {
    String headerName() default "";
}

package com.dangdang.common.utils.annotation;

import java.lang.annotation.*;

/**
 * Create by tianjiaqin 2018/11/12
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {
    String headerName() default "";
}

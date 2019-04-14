package com.dangdang.service.biz.anno;

import java.lang.annotation.*;

/**
 * Create by tianjiaqin 2019-04-14
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnoInterfaceAspectJ {

    /**
     * 自定义注解
     *
     *      java中有四种元注解（JDK自带的注解）
     *      @Target  表明注解作用的范围,里面是一个数组，具体在  ElementType.的枚举值中查看，经常使用的有 type,method
     *      @Retention 表示需要在什么级别保存该注释信息，用于描述注解的生命周期,也是一个枚举RetentionPoicy来决定的
     *      @Documented 如果用javadoc生成文档时，想把注解也生成文档，就带这个
     *      @Inherited
     *          元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，
     *          则这个annotation将被用于该class的子类。注意,@Inherited annotation类型是被标注过的class的子类所继承。
     *          类并不从它所实现的接口继承annotation，方法并不从它所重载的方法继承annotation
     *
     *
     */

    public String description();


}

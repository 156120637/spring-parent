package com.dangdang.web.easyui.config;

import com.dangdang.web.easyui.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器先关的配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*注册拦截器*/
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/toLogin","/user/register", "/");/*排除的方法*/
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*自定义页面视图  / 是访问登录页login*/
        registry.addViewController("/").setViewName("login");
    }
}

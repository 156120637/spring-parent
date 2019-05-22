package com.dangdang.service.biz.service.impl;

import com.dangdang.service.biz.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;


/**
 * Create by tianjiaqin 2019/4/12-22-48
 */
@Slf4j
@Component
@EnableRetry
public class RetryServiceImpl implements RetryService {

    /**
     * spring-retry的使用
     * 1） 使用注解@EnableRetry,标注这个类使用重试机制
     * 2） 使用 @Retryable 注解标注方法表示这个方法执行重试机制
     *  （1）value = 指定处理的异常类
     *  （2）maxAttempts 重试的次数
     *  （3）backoff 重试补偿策略
     *     1. delay 延长多久执行重试 long类型 默认是3000L
     *     2. multiplier 延迟的倍数 默认是3
     * 3） 使用 @Recover 标注当重试不成功时的处理方式
     *      注意； 参数必须是@Retryable中捕捉到的异常，不然不会生效
     *
     * 注意点：
     *  1. 使用重试的时候最好不要揉在业务中，可以将需要重试的方法单独拆出来，这样不会影响整体业务。
     *  2. @Recove 注解的方法参数必须是重试铺捉到的异常，不然不会生效。
     *  3. 重试次数一定要注意，不要过多，影响下一次业务的流程。时间间隔不要设置太长，一定指定捕获的具体异常。重试是同步执行的，不是异步的。
     *  4. 目前来说重试是从头开始的，不能从出错的位置开始，而且重试是同步的。
     *
     *
     *
     * @return
     */

    @Override
    @Retryable(value = RuntimeException.class , maxAttempts = 2,backoff = @Backoff(delay = 1000L , multiplier = 2))
    public String retryMethod() {

        log.info("this is retry method ... ");

        return null;
    }


    @Recover
    public void recoverMethod(RuntimeException exception){
        log.info("retray 2 times has error ,please check this exception {}", exception);
    }
}

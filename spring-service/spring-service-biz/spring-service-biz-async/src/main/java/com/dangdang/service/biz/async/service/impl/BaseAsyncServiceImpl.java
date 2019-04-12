package com.dangdang.service.biz.async.service.impl;

import com.dangdang.service.biz.async.service.BaseAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Create by tianjiaqin 2019/4/12-23-09
 */
@Slf4j
@Component
@EnableAsync
public class BaseAsyncServiceImpl implements BaseAsyncService {

    /**
     * 必须使用  @EnableAsync 标注开启异步任务。
     *    @Async 标注在方法上，标明这是异步方法。
     */

    @Async
    @Override
    public void baseAsync() {

    }
}

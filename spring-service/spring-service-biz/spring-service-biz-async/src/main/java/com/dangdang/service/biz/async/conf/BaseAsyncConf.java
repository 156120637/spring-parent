package com.dangdang.service.biz.async.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Create by tianjiaqin 2019/4/12-23-12
 */
@Configuration
@PropertySource({"classpath:asynctask.properties"})
public class BaseAsyncConf {

    /**
     *  异步任务在开发中用的还是挺多的，为了不影响和保证接口在正常时间内响应，可能会起异步任务做做一些影响接口效率的事情。
     *  在多核cpu中异步任务还是占用很大优势的，只要控制住异步任务的数量，就不会有太大的问题。
     */


    @Value("${base.async.corePoolSize}")
    private int corePoolSize;

    @Value("${base.async.maxPoolSize}")
    private int maxPoolSize;

    @Value("${base.async.queueCapacity}")
    private int queueCapacity;

    @Value("${base.async.keepAliveSeconds}")
    private int keepAliveSeconds;

    @Value("${base.async.threadNamePrefix}")
    private String threadNamePrefix;

    @Value("${base.async.awaitTerminationSeconds}")
    private int awaitTerminationSeconds;

    /**
     *  配置线程池
     *  @return
     */
    @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        taskExecutor.setCorePoolSize(corePoolSize);
        //线程池维护线程的最大数量,只有在缓冲队列满了之后才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(maxPoolSize);
        //缓存队列 保持活跃量
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        taskExecutor.setThreadNamePrefix(threadNamePrefix);
        // 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //表明等待所有线程执行完，默认为false
        taskExecutor.setWaitForTasksToCompleteOnShutdown(false);
        // 等待的时间，因为不能无限的等待下去。
        taskExecutor.setAwaitTerminationSeconds(awaitTerminationSeconds);
        taskExecutor.initialize();
        return taskExecutor;
    }

}

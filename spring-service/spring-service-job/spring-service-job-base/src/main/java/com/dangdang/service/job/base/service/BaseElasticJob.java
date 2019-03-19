package com.dangdang.service.job.base.service;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create by tianjiaqin 2018-12-22
 */
@Slf4j
@Component
@ElasticSimpleJob(jobName = "baseElasticJob",
        cron = "*/2 * * * * ?",
        shardingTotalCount = 1,
        shardingItemParameters = "0=zero")
public class BaseElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {

        /**
         * 其实elastic-job最大的好处是可以分片，多机器部署，我觉得这是elastic-job比其他定时作业强的很大一点
         * shardingContext.getShardingItem()  获取每个机器的分片信息  总片信息  shardingTotalCount配置的
         * shardingItemParameters 分片的名称
         *
         */

        log.info("job has start 2 second  ,please check.....begin your bussiness code");


    }
}

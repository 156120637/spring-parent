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
@ElasticSimpleJob(jobName = "verificateDataCollect",
        cron = "*/2 * * * * ?",
        shardingTotalCount = 1,
        shardingItemParameters = "0=zero")
public class BaseElasticJob implements SimpleJob {


    @Override
    public void execute(ShardingContext shardingContext) {

        log.info("job has start 2 second  ,please check.....begin your bussiness code");




    }
}

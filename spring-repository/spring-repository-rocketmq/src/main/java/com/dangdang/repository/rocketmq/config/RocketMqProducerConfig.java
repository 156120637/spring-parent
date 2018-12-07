package com.dangdang.repository.rocketmq.config;


import lombok.Data;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by tianjiaqin on 2018-12-7
 */

@Data
@PropertySource("classpath:rocketmq-producer.properties")
@ConfigurationProperties(prefix = "rocketmq.producer")
@Configuration
public class RocketMqProducerConfig {
    private String namesrvAddr;
    /**
     * 普通消息的生产者
     */
    private String producerGroupName;
    private String producerInstanceName;
    /**
     * 事务消息的生产者
     */
    private String transactionProducerGroupName;
    private String transactionProducerInstanceName;

    /**
     * 初始化向rocketmq发送普通消息的生产者
     */
    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        /**
         * 一个应用创建一个Producer，由应用来维护此对象，可以设置为全局对象或者单例<br>
         * 注意：ProducerGroupName需要由应用来保证唯一<br>
         * ProducerGroup这个概念发送普通的消息时，作用不大，但是发送分布式事务消息时，比较关键，
         * 因为服务器会回查这个Group下的任意一个Producer
         */
        DefaultMQProducer producer = new DefaultMQProducer(producerGroupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setInstanceName(producerInstanceName);
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendAsyncFailed(10);

        /**
         * Producer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         * 注意：切记不可以在每次发送消息时，都调用start方法
         */
        producer.start();
        return producer;
    }

    /**
     * 初始化向rocketmq发送事务消息的生产者
     */
    @Bean
    public TransactionMQProducer transactionMQProducer() throws MQClientException {
        /**
         * 一个应用创建一个Producer，由应用来维护此对象，可以设置为全局对象或者单例<br>
         * 注意：ProducerGroupName需要由应用来保证唯一<br>
         * ProducerGroup这个概念发送普通的消息时，作用不大，但是发送分布式事务消息时，比较关键，
         * 因为服务器会回查这个Group下的任意一个Producer
         */
        TransactionMQProducer producer = new TransactionMQProducer(transactionProducerGroupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setInstanceName(transactionProducerInstanceName);
        producer.setRetryTimesWhenSendAsyncFailed(10);

        // 事务回查最小并发数
        producer.setCheckThreadPoolMinSize(2);
        // 事务回查最大并发数
        producer.setCheckThreadPoolMaxSize(2);
        // 队列数
        producer.setCheckRequestHoldMax(2000);

        /**
         * Producer对象在使用之前必须要调用start初始化，初始化一次即可<br>
         * 注意：切记不可以在每次发送消息时，都调用start方法
         */
        producer.start();
        return producer;
    }

}

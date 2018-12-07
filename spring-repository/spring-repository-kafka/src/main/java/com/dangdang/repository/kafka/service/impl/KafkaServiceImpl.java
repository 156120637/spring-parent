package com.dangdang.repository.kafka.service.impl;


import com.dangdang.repository.kafka.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Create by tianjiaqin 2018-12-06
 */
@Slf4j
@Component
public class KafkaServiceImpl implements KafkaService {
    
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void sendMessage(String topic, String key, String message) {
        this.kafkaTemplate.setDefaultTopic(topic);
        this.kafkaTemplate.sendDefault(key, message);
    }

    @Override
    public void sendMessage(String topic, String message) {
        this.kafkaTemplate.setDefaultTopic(topic);
        this.kafkaTemplate.sendDefault(message);
    }

    @Override
    public void sendMessage(String message){
        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.sendDefault(message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                log.info("message send to:{},partition:{},offset:{}", new Object[]{metadata.topic(), metadata.partition(), metadata.offset()});
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("message send failed:", ex);
            }

        });
    }
}

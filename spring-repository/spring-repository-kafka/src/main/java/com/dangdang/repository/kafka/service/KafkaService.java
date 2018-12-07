package com.dangdang.repository.kafka.service;

/**
 * Create by tianjiaqin 2018-12-06
 */
public interface KafkaService {

    public void sendMessage(String message);

    public void sendMessage(String topic, String message);

    public void sendMessage(String topic, String key, String message);

}

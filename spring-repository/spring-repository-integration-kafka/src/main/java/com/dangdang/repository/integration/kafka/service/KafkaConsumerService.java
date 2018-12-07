package com.dangdang.repository.integration.kafka.service;

import java.util.Map;

/**
 * Create by tianjiaqin 2018-12-06
 */

public interface KafkaConsumerService {

    public void processMessage(Map<String, Map<Integer, String>> msgs);
}

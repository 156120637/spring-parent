package com.dangdang.repository.integration.kafka.service.impl;


import com.dangdang.repository.integration.kafka.service.KafkaConsumerService;
import lombok.extern.slf4j.Slf4j;


import java.util.*;

/**
 * Create by tianjiaqin 2018-12-06
 */
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @Override
    public void processMessage(Map<String, Map<Integer, String>> msgs) {
        for (Map.Entry<String, Map<Integer, String>> entry : msgs.entrySet()) {
            LinkedHashMap<Integer, String> messages = (LinkedHashMap<Integer, String>) entry.getValue();
            Set<Integer> partition = messages.keySet();
            Collection<String> values = messages.values();
            for (Iterator<String> iterator = values.iterator(); iterator.hasNext(); ) {
                String message = "[" + iterator.next() + "]";
                log.info("kafka msg is {}", message);
                // 转换json message
            }

        }
    }
}

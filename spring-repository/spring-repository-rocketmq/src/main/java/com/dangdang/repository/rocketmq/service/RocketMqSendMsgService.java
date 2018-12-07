package com.dangdang.repository.rocketmq.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tianjiaqin on 2018-12-7
 */
@Slf4j
@Component
public class RocketMqSendMsgService {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    @Autowired
    private TransactionMQProducer transactionMQProducer;

    public SendResult sendMsg(String topic, String tags, String keys, String msg) {
        log.info("send message topic={}, tags={}, keys={}, body={}", topic, tags, keys, msg);

        Message message = new Message(topic, tags, keys, msg.getBytes());

        SendResult result = null;
        try {
            result = defaultMQProducer.send(message);
            log.info("send message response result . {}", result.toString());
        } catch (Exception e){
            log.error("send message is error.{}", e);
            return result;
        }
        return result;
    }

    public SendResult sendTransactionMsg(String topic, String tags, String keys, String msg) {
        log.info("send message topic={}, tags={}, keys={}, body={}", topic, tags, keys, msg);

        Message message = new Message(topic, tags, keys, msg.getBytes());

        SendResult result = null;
        try {
            result = transactionMQProducer.sendMessageInTransaction(message, 4);

            log.info("send transaction message response result . {}", result.toString());
        } catch (Exception e) {
            log.error("send transaction message is error.{}", e);
            return result;
        }
        return result;
    }
}

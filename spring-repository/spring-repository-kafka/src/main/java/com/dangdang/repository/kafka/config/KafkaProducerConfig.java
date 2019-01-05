package com.dangdang.repository.kafka.config;
import lombok.Data;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Data
@PropertySource("classpath:kafka-producer.properties")
@ConfigurationProperties(prefix = "kafka.producer")
@Configuration
@EnableKafka
public class KafkaProducerConfig {

    private String bootstrapServers;
    private String retries;
    private String batchSize;
    private String lingerMs;
    private String bufferMemory;
    private String acks;
    private String keySerializer;
    private String valueSerializer;

    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // 有可能导致broker接收到重复的消息,默认值为3
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        // 每次批量发送消息的数量
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        // 默认0ms，在异步IO线程被触发后（任何一个topic，partition满都可以触发）
        props.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        // producer可以用来缓存数据的内存大小. 如果数据产生速度大于向broker发送的速度，producer会阻塞或者抛出异常
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        // producer需要server接收到数据之后发出的确认接收的信号，此项配置就是指procuder需要多少个这样的确认信号
        props.put(ProducerConfig.ACKS_CONFIG, acks);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        return props;
    }

    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}

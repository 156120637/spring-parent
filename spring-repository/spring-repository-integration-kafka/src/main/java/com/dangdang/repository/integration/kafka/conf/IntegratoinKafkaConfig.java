package com.dangdang.repository.integration.kafka.conf;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Create by tianjiaqin 2019/1/11-17-25
 */
@Data
@Slf4j
@Configuration
@ImportResource({"classpath:spring-kafka-consumer.xml"})
public class IntegratoinKafkaConfig {



}

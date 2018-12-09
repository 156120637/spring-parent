package com.dangdang.repository.redis.config;
//

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@PropertySource("classpath:redis-sentinel.properties")
@ConfigurationProperties(prefix = "redis.adapter")
@Configuration
public class RedisSourceSentinelConfig {

    private Integer maxIdle;
    private Integer minIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean testWhileIdle;
    private Integer numTestsPerEvictionRun;
    private Long timeBetweenEvictionRunsMillis;
    private String masterName;
    private String sentinel;

    @Bean(name = "jedisPoolConfigSentinel")
    @Qualifier("jedisPoolConfigSentinel")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        return jedisPoolConfig;
    }

    @Bean
    public JedisSentinelPool jedisSentinelPool(@Qualifier("jedisPoolConfigSentinel") JedisPoolConfig jedisPoolConfig) {

        List<String> sentinelList = Arrays.asList(sentinel.split(","));
        Set<String> sentinels = new HashSet<>(sentinelList);
        return new JedisSentinelPool(masterName, sentinels, jedisPoolConfig);
    }
}

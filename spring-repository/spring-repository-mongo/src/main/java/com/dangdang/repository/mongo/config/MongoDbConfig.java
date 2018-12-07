package com.dangdang.repository.mongo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by tianjiaqin 2018-12-7
 */
@Data
@PropertySource({"classpath:mongo.properties"})
@Configuration
public class MongoDbConfig {
    @Value("${mongo.database}")
    private String database;
    @Value("${mongo.address}")
    private String address;
    @Value("${mongo.username}")
    private String username;
    @Value("${mongo.password}")
    private String password;
    @Value("${mongo.options.min-connections-per-host}")
    private Integer minConnectionsPerHost;
    @Value("${mongo.options.max-connections-per-host}")
    private Integer maxConnectionsPerHost;
    @Value("${mongo.options.threads-allowed-to-block-for-connection-multiplier}")
    private Integer threadsAllowedToBlockForConnectionMultiplier;
    @Value("${mongo.options.server-selection-timeout}")
    private Integer serverSelectionTimeout;
    @Value("${mongo.options.max-wait-time}")
    private Integer maxWaitTime;
    @Value("${mongo.options.max-connection-idel-time}")
    private Integer maxConnectionIdleTime;
    @Value("${mongo.options.max-connection-life-time}")
    private Integer maxConnectionLifeTime;
    @Value("${mongo.options.connect-timeout}")
    private Integer connectTimeout;
    @Value("${mongo.options.socket-timeout}")
    private Integer socketTimeout;
    @Value("${mongo.options.socket-keep-alive}")
    private Boolean socketKeepAlive;
    @Value("${mongo.options.ssl-enabled}")
    private Boolean sslEnabled;
    @Value("${mongo.options.heartbeat-connect-timeout}")
    private Integer heartbeatConnectTimeout;
    @Value("${mongo.options.heartbeat-socket-timeout}")
    private Integer heartbeatSocketTimeout;
    @Value("${mongo.options.local-threshold}")
    private Integer localThreshold;

    @Bean
    @Primary
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory());
    }


    @Bean
    public MongoDbFactory mongoDbFactory() {
        //客户端配置（连接数，副本集群验证）
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(maxConnectionsPerHost);
        builder.minConnectionsPerHost(minConnectionsPerHost);
        builder.threadsAllowedToBlockForConnectionMultiplier(
                threadsAllowedToBlockForConnectionMultiplier);
        builder.serverSelectionTimeout(serverSelectionTimeout);
        builder.maxWaitTime(maxWaitTime);
        builder.maxConnectionIdleTime(maxConnectionIdleTime);
        builder.maxConnectionLifeTime(maxConnectionLifeTime);
        builder.connectTimeout(connectTimeout);
        builder.socketTimeout(socketTimeout);
        builder.socketKeepAlive(socketKeepAlive);
        builder.sslEnabled(sslEnabled);
        builder.heartbeatConnectTimeout(heartbeatConnectTimeout);
        builder.heartbeatSocketTimeout(heartbeatSocketTimeout);
        builder.localThreshold(localThreshold);

        MongoClientOptions mongoClientOptions = builder.build();

        // MongoDB地址列表
        List<ServerAddress> serverAddresses = new ArrayList<>();
        String[] mongoAddr = address.split(",");
        for (String addr : mongoAddr) {
            String[] hostAndPort = addr.split(":");
            String host = hostAndPort[0];
            Integer port = Integer.parseInt(hostAndPort[1]);
            ServerAddress serverAddress = new ServerAddress(host, port);
            serverAddresses.add(serverAddress);
        }
        // 连接认证
        List<MongoCredential> mongoCredentialList = new ArrayList<>();
        if(StringUtils.isNotBlank(username)){
            mongoCredentialList.add(MongoCredential.createScramSha1Credential(username ,database ,password.toCharArray()));
        }
        //创建客户端和Factory
        MongoClient mongoClient = new MongoClient(serverAddresses,mongoCredentialList, mongoClientOptions);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, database);
        return mongoDbFactory;
    }

}

package com.dangdang.repository.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringRepositoryMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRepositoryMysqlApplication.class, args);
    }
}

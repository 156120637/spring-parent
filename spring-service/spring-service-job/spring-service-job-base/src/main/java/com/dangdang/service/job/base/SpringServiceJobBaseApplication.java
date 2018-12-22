package com.dangdang.service.job.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringServiceJobBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServiceJobBaseApplication.class, args);
    }

}


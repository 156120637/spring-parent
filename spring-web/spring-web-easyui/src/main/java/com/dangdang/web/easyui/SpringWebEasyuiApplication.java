package com.dangdang.web.easyui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringWebEasyuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebEasyuiApplication.class, args);
    }

}


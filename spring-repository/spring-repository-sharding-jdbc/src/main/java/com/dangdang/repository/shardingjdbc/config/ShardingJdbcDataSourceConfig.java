package com.dangdang.repository.shardingjdbc.config;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {
        "com.dangdang.repository.shardingjdbc.mapper"
},
        sqlSessionFactoryRef = "sqlSessionFactoryShardingJdbc")
public class ShardingJdbcDataSourceConfig {

    @Resource
    private DataSource riskShardingDataSource;

    @Bean(name = "sqlSessionFactoryShardingJdbc")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(riskShardingDataSource);

        // 驼峰配置
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);
        return sessionFactory.getObject();
    }

}

package com.dangdang.repository.shardingsphare.mapper.sql;

import com.dangdang.common.utils.sql.BatchInsertSQLBuilder;
import com.dangdang.repository.shardingsphare.model.Customer;

/**
 * Create by tianjiaqin 2019-06-23
 */
public class CustomerMapperProvider {

    public String save(Customer customer) {

        BatchInsertSQLBuilder<Customer> sql = new BatchInsertSQLBuilder();
        sql.setData(customer);
        sql.setInsertTable("customer");
        sql.setSelective(true);
        return sql.toString();

    }

}

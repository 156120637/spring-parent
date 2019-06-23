package com.dangdang.repository.shardingsphare.mapper;

import com.dangdang.repository.shardingsphare.mapper.sql.CustomerMapperProvider;
import com.dangdang.repository.shardingsphare.model.Customer;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

/**
 * Create by tianjiaqin 2019-06-23
 */
public interface CustomerMapper {


    /**
     * 新的shardignsphare 在原来的 1,2,3 的基础上完善了很多东西，不止是分库分表，还有数据脱敏等特性
     * 而4.0 是apache自从接手之后的第一个官宣版本，很多新的特性，也解决了很多的问题。
     *
     * 我们可以更新新的版本，因为新的版本很多的类名和配置方式以及包的名称都发生了变化 ，但是在我们熟悉之后会更加的
     * 认识到这个插件的好用之处。
     *
     *
     *
     */


    @InsertProvider(type = CustomerMapperProvider.class , method = "save")
    public void save(Customer customer);

    @Select("select * from customer where custid = #{custid}")
    public Customer select(Long custid);

}

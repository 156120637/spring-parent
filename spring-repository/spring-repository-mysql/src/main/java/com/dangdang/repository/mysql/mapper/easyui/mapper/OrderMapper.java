package com.dangdang.repository.mysql.mapper.easyui.mapper;

import com.dangdang.repository.mysql.mapper.easyui.entity.Order;
import com.dangdang.repository.mysql.mapper.easyui.entity.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orid);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 查询所有订单的详细信息
     * @return
     */
    public List<Order> selectOrderAddressUser();
}
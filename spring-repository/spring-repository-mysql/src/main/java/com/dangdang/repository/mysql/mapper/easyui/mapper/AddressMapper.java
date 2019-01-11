package com.dangdang.repository.mysql.mapper.easyui.mapper;


import com.dangdang.repository.mysql.mapper.easyui.entity.Address;
import com.dangdang.repository.mysql.mapper.easyui.entity.AddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AddressMapper {
    int countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(String adid);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(String adid);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}
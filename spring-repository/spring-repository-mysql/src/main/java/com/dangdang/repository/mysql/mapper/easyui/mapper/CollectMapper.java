package com.dangdang.repository.mysql.mapper.easyui.mapper;

import com.dangdang.repository.mysql.mapper.easyui.entity.Collect;
import com.dangdang.repository.mysql.mapper.easyui.entity.CollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    int countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(String scid);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(String scid);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    /**
     * 查询用户下的收藏信息 包商品和商铺信息
     * @param userid
     * @return
     */
    List<Collect> selectCollectGoodsShop(String userid);
}
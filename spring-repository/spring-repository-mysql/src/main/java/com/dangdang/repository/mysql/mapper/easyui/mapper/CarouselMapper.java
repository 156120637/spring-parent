package com.dangdang.repository.mysql.mapper.easyui.mapper;

import com.dangdang.repository.mysql.mapper.easyui.entity.Carousel;
import com.dangdang.repository.mysql.mapper.easyui.entity.CarouselExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarouselMapper {
    int countByExample(CarouselExample example);

    int deleteByExample(CarouselExample example);

    int deleteByPrimaryKey(String caid);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    List<Carousel> selectByExample(CarouselExample example);

    Carousel selectByPrimaryKey(String caid);

    int updateByExampleSelective(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByExample(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
}
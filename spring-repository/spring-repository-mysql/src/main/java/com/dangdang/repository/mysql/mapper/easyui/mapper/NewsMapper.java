package com.dangdang.repository.mysql.mapper.easyui.mapper;

import com.dangdang.repository.mysql.mapper.easyui.entity.News;
import com.dangdang.repository.mysql.mapper.easyui.entity.NewsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int deleteByPrimaryKey(String neid);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(String neid);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    /**
     * 查询所有资讯  和  所有关系
     * @return
     */
    List<News> selectNewsUserCategory();
}
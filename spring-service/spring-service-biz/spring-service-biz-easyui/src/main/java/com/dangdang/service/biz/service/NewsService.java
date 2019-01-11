package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.News;
import com.dangdang.repository.mysql.mapper.easyui.entity.NewsComment;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 资讯相关的操作
 */
public interface NewsService {

    /**
     * 添加咨询下信息
     * @param news
     * @return
     */
    public News addNews(News news);

    /**
     * 修改资讯信息
     * @param news
     * @return
     */
    public News modifyNews(News news);


    /**
     * 查询单个news信息
     * @param neid
     * @return
     */
    public News findById(String neid);


    /**
     * 按照分类查询所有的资讯
     * @param categoryId
     * @return
     */
    public List<News> findByCategoryId(String categoryId);

    /**
     * 查询当期那用户下的所有资讯信息
     * @param userid
     * @return
     */
    public List<News> findByUserId(String userid);

    /**
     * 查询所有的news 1 1
     * @return
     */
    public List<News> findAll();

    /**
     * 分页查找数据
     * @param page
     * @param rows
     * @return
     */
    public Page<News> findByPage(Integer page, Integer rows);


    /**
     * 统计条数
     * @return
     */
    public Integer countNews();


    /**
     * 删除一条数据
     * @param id
     */
    public void removeNews(String id);

    /**
     * 查询所有评论信息
     * @param neid
     * @return
     */
    public List<NewsComment> findAllComment(String neid);

}

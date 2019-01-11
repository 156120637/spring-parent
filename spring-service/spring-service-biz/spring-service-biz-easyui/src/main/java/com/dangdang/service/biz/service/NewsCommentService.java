package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.NewsComment;

import java.util.List;

/**
 * 资讯相关的评论操作
 */
public interface NewsCommentService {

    /**
     * 添加商铺信息
     * @param newsComment
     * @return
     */
    public NewsComment addNewsComment(NewsComment newsComment);

    /**
     * 删除单个评论信息
     * @param neid
     */
    public void removeNewsComment(String neid);


    /**
     * 查询该资讯下的所有评论
     * @param newsId
     * @return
     */
    public List<NewsComment> findByNewsId(String newsId);


    /**
     * 查询用户所有的评论信息
     * @param userid
     * @return
     */
    public List<NewsComment> findByUserId(String userid);


    /**
     * 查询一条数据
     * @param neid
     * @return
     */
    public NewsComment findById(String neid);


}

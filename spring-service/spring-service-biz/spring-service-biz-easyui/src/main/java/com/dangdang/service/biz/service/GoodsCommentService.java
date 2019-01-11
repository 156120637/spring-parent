package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.GoodsComment;

import java.util.List;

/**
 * 商品评论信息
 */
public interface GoodsCommentService {


    /**
     * 添加新的商品评论信息
     * @param goodsComment
     */
    public void addGoodsComment(GoodsComment goodsComment);

    /**
     * 查询单个商品下的所有的信息
     * @param goid
     * @return
     */
    public List<GoodsComment> findByGoid(String goid);


    /**
     * 根据用户id'查询该用户评论的所有内容
     * @param userid
     * @return
     */
    public List<GoodsComment> findByUserId(String userid);

    /**
     * 删除一条评论信息
     * @param goid
     */
    public void removeGoodsComment(String goid);


    /**
     * 查询该商品下的所有评论信息
     * @param goid
     * @return
     */
    public List<GoodsComment> findGoodsComment(String goid);


}

package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Goods;
import com.dangdang.repository.mysql.mapper.easyui.entity.GoodsComment;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 商品相关的操作
 */
public interface GoodsService {

    /**
     * 添加商品信息
     * @param goods
     * @return
     */
    public Goods addGoods(Goods goods);


    /**
     * 删除商品信息
     * @param goid
     */
    public void removeGoods(String goid);


    /**
     * 修改商品信息
     * @param goods
     * @return
     */
    public Goods modifyGoods(Goods goods);


    /**
     * 查询一条商品数据
     * @param goid
     * @return
     */
    public Goods findByGoid(String goid);


    /**
     * 查询当前商铺下的所有商品信息
     * @param shopid
     * @return
     */
    public List<Goods> findByShopId(String shopid);


    /**
     * 查询该分类下的所有的商品
     * @param categoryId
     * @return
     */
    public List<Goods> findByCategoryId(String categoryId);


    /**
     * 查询所有的商品
     * @return
     */
    public List<Goods> findAll();

    /**
     * 分页查询数据
     * @param page
     * @param rows
     * @return
     */
    public Page<Goods> findByPage(Integer page, Integer rows);

    /**
     * 查询条数
     * @return
     */
    public Integer countGoods();

    /**
     * 查询该商品下的所有分类
     * @param goid
     * @return
     */
    public List<GoodsComment> findAllComment(String goid);


}

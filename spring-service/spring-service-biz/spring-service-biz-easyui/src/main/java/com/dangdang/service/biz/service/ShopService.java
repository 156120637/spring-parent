package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Shop;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 商铺相关的操作
 */
public interface ShopService {

    /**
     * 添加商铺信息
     *
     * @param shop
     * @return
     */
    public Shop addShop(Shop shop);


    /**
     * 修改商铺信息
     *
     * @param shop
     * @return
     */
    public Shop modifyShop(Shop shop);

    /**
     * 查询所有的商铺
     *
     * @return
     */
    public List<Shop> findAll();

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    public Page<Shop> findByPage(Integer page, Integer rows);

    /**
     * 查询单个商铺信息
     *
     * @param shid
     * @return
     */
    public Shop findByShid(String shid);

    /**
     * 删除商铺信息
     * @param shid
     */
    public void removeShop(String shid);

    /**
     * 查询数据条数
     * @return
     */
    public Integer countShop();


}

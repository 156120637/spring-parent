package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Cart;

import java.util.List;

/**
 * Cart 购物车先关的操作
 */

public interface CartService {

    /**
     * 根据用户iod查询当前用户的购物车
     * @param userid
     * @return
     */
    public List<Cart> findByUserId(String userid);


    /**
     * 修改购物车 数量 -- 生成订单
     * @param cart
     * @return
     */
    public Cart modifyCart(Cart cart);


    /**
     * 删除购物车
     * @param caid
     */
    public void removeCart(String caid);


    /**
     * 添加到购物车  - 如果已存在就加1 如果不存在就加入购物车
     * @param cart
     * @return
     */
    public Cart addCart(Cart cart);

}

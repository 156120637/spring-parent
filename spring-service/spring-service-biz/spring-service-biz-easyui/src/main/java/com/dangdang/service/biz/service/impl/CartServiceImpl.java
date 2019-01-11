package com.dangdang.service.biz.service.impl;


import com.dangdang.repository.mysql.mapper.easyui.entity.Cart;
import com.dangdang.repository.mysql.mapper.easyui.mapper.CartMapper;
import com.dangdang.service.biz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Cart> findByUserId(String userid) {

        List<Cart> carts = null;
        try {
            carts = cartMapper.selectCartGoods(userid);
            System.out.println(carts);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错,请稍后重试");
        }
        return carts;
    }

    @Override
    public Cart modifyCart(Cart cart) {

        try {
            cartMapper.updateByPrimaryKeySelective(cart);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错.稍后重试");
        }
        return cart;
    }

    @Override
    public void removeCart(String caid) {
        try {
            cartMapper.deleteByPrimaryKey(caid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除出错,请稍后重试");
        }
    }


    @Override
    public Cart addCart(Cart cart) {
        try {
            cart.setCaid(UUID.randomUUID().toString());
            cart.setCacreate(new Date());
            cart.setOrderstatus(1);
            cartMapper.insertSelective(cart);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加错误,请稍后重试");
        }
        return cart;
    }
}

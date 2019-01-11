package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Shop;
import com.dangdang.repository.mysql.mapper.easyui.entity.ShopExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.ShopMapper;
import com.dangdang.service.biz.service.ShopService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("shopService")
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop addShop(Shop shop) {

        try {
            shop.setShid(UUID.randomUUID().toString());
            shop.setShcreate(new Date());
            shop.setShrole("白金");// 根据业务来
            shopMapper.insertSelective(shop);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络出错,请重试");
        }
        return shop;
    }

    @Override
    public Shop modifyShop(Shop shop) {

        try {
            shopMapper.updateByPrimaryKeySelective(shop);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
        return shop;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Shop> findAll() {

        List<Shop> shops = null;
        try {
            ShopExample example = new ShopExample();
            shops =  shopMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
        return shops;
    }

    @Override
    public Page<Shop> findByPage(Integer page, Integer rows) {
        Page<Shop> shops = null;
        try {
            ShopExample example = new ShopExample();
            PageHelper.startPage(page , rows);
            shops = (Page<Shop>) shopMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
        return shops;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Shop findByShid(String shid) {

        Shop shop = null;
        try {
            shop = shopMapper.selectByPrimaryKey(shid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }

        return shop;
    }

    @Override
    public void removeShop(String shid) {
        try {
            shopMapper.deleteByPrimaryKey(shid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
    }

    @Override
    public Integer countShop() {
        int i = 0;
        try {
            i = shopMapper.countByExample(new ShopExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return i;
    }
}

package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Goods;
import com.dangdang.repository.mysql.mapper.easyui.entity.GoodsComment;
import com.dangdang.repository.mysql.mapper.easyui.entity.GoodsExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.GoodsCommentMapper;
import com.dangdang.repository.mysql.mapper.easyui.mapper.GoodsMapper;
import com.dangdang.service.biz.service.GoodsService;
import com.dangdang.common.utils.easyui.util.FileUploadUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsCommentMapper goodsCommentMapper;

    @Override
    public Goods addGoods(Goods goods) {

        try {
            goods.setGoid(UUID.randomUUID().toString());
            goods.setGocreate(new Date());
            goods.setGoviewcount(0);
            goodsMapper.insertSelective(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * allEntries 全部清除缓存value下的内容
     * @param goid
     */
    @CacheEvict(value = "goods",allEntries = true)
    @Override
    public void removeGoods(String goid) {
        try {

            Goods goods = goodsMapper.selectByPrimaryKey(goid);
            File file = new File(FileUploadUtil.getResource() + goods.getGoimage());
            if(file.exists()){
                file.delete();
            }
            goodsMapper.deleteByPrimaryKey(goid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
    }

    @CacheEvict(value = "goods" ,allEntries = true)
    @Override
    public Goods modifyGoods(Goods goods) {

        try {
            goodsMapper.updateByPrimaryKeySelective(goods);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }

        return goods;
    }

    @Cacheable(value = "goods", key = "#goid")
    @Override
    public Goods findByGoid(String goid) {

        Goods goods = null;
        try {
            goods = goodsMapper.selectByPrimaryKey(goid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }

        return goods;
    }

    @Cacheable(value = "goods" ,key = "#shopid")
    @Override
    public List<Goods> findByShopId(String shopid) {

        List<Goods> goods = null;
        try {
            GoodsExample example = new GoodsExample();
            example.createCriteria().andShopidEqualTo(shopid);
            goods = goodsMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }

        return goods;
    }

    @Cacheable(value = "goods",key = "#categoryId")
    @Override
    public List<Goods> findByCategoryId(String categoryId) {

        List<Goods> goods = null;
        try {
            GoodsExample example = new GoodsExample();
            example.createCriteria().andCategoryidEqualTo(categoryId);
            goods = goodsMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }

        return goods;
    }

    @Cacheable("goods")
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Goods> findAll() {

        List<Goods> goods = null;
        try {
            goods = goodsMapper.selectGoodsCategoryShop();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
        return goods;
    }

    @Cacheable("goods")
    @Override
    public Page<Goods> findByPage(Integer page, Integer rows) {
        Page<Goods> goods = null;
        try {
            PageHelper.startPage(page , rows);
            goods = (Page<Goods>) goodsMapper.selectGoodsCategoryShop();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
        return goods;
    }

    @Override
    public Integer countGoods() {

        int i = 0;
        try {
            i = goodsMapper.countByExample(new GoodsExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return i;
    }

    @Override
    public List<GoodsComment> findAllComment(String goid) {
        List<GoodsComment> goodsComments = null;
        try {
            goodsComments = goodsCommentMapper.selectGoodsComment(goid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return goodsComments;
    }
}

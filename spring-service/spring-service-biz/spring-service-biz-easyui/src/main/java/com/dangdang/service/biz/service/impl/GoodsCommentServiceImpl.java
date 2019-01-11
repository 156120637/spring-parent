package com.dangdang.service.biz.service.impl;


import com.dangdang.repository.mysql.mapper.easyui.entity.GoodsComment;
import com.dangdang.repository.mysql.mapper.easyui.entity.GoodsCommentExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.GoodsCommentMapper;
import com.dangdang.service.biz.service.GoodsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("goodsCommentService")
@Transactional
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired
    private GoodsCommentMapper goodsCommentMapper;

    @Override
    public void addGoodsComment(GoodsComment goodsComment) {
        try {
            // 需要获取session中的当前用户id
            goodsComment.setUserid("1");
            goodsComment.setGcoid(UUID.randomUUID().toString());
            goodsComment.setGccreate(new Date());
            goodsCommentMapper.insertSelective(goodsComment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请稍后重试");
        }
    }

    @Override
    public List<GoodsComment> findByGoid(String goid) {

        List<GoodsComment> goodsComments = null;
        try {
            GoodsCommentExample example = new GoodsCommentExample();
            example.createCriteria().andGoodsidEqualTo("goid");
            goodsComments = goodsCommentMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请稍后重试");
        }

        return goodsComments;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<GoodsComment> findByUserId(String userid) {
        List<GoodsComment> goodsComments = null;
        try {
            goodsComments = goodsCommentMapper.selectCommentGoods(userid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请稍后重试");
        }
        return goodsComments;
    }

    @Override
    public void removeGoodsComment(String goid) {
        try {
            goodsCommentMapper.deleteByPrimaryKey(goid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("");
        }
    }

    @Override
    public List<GoodsComment> findGoodsComment(String goid) {
        List<GoodsComment> goodsComments = null;
        try {
            goodsComments = goodsCommentMapper.selectGoodsComment(goid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试.");
        }
        return goodsComments;
    }
}

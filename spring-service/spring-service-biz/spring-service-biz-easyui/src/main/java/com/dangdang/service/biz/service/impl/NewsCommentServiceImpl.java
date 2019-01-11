package com.dangdang.service.biz.service.impl;


import com.dangdang.repository.mysql.mapper.easyui.entity.NewsComment;
import com.dangdang.repository.mysql.mapper.easyui.entity.NewsCommentExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.NewsCommentMapper;
import com.dangdang.service.biz.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("newsCommentService")
@Transactional
public class NewsCommentServiceImpl implements NewsCommentService {

    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Override
    public NewsComment addNewsComment(NewsComment newsComment) {

        try {
            newsComment.setUserid("1");// 用户id值
            newsComment.setNcoid(UUID.randomUUID().toString());
            newsComment.setNccreate(new Date());
            newsCommentMapper.insertSelective(newsComment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请少抽重试");
        }

        return newsComment;
    }

    @Override
    public void removeNewsComment(String neid) {
        try {
            newsCommentMapper.deleteByPrimaryKey(neid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请稍后重试");
        }
    }

    @Override
    public List<NewsComment> findByNewsId(String newsId) {

        List<NewsComment> newsComments = null;
        try {
            NewsCommentExample example = new NewsCommentExample();
            example.createCriteria().andNewsidEqualTo(newsId);
            newsComments = newsCommentMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请少抽重试");
        }

        return newsComments;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewsComment> findByUserId(String userid) {

        List<NewsComment> newsComments = null;
        try {
            NewsCommentExample example = new NewsCommentExample();
            example.createCriteria().andUseridEqualTo(userid);
            newsComments = newsCommentMapper.selectCommentNews(userid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,稍后重试");
        }
        return newsComments;
    }

    @Override
    public NewsComment findById(String neid) {

        NewsComment newsComment = null;
        try {
            newsComment = newsCommentMapper.selectByPrimaryKey(neid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }

        return newsComment;
    }
}

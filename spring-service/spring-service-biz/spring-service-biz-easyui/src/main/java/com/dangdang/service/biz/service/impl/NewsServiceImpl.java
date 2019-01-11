package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.News;
import com.dangdang.repository.mysql.mapper.easyui.entity.NewsComment;
import com.dangdang.repository.mysql.mapper.easyui.entity.NewsExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.NewsCommentMapper;
import com.dangdang.repository.mysql.mapper.easyui.mapper.NewsMapper;
import com.dangdang.repository.mysql.mapper.easyui.mapper.UserMapper;
import com.dangdang.service.biz.service.NewsService;
import com.dangdang.common.utils.easyui.util.FileUploadUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public News addNews(News news) {
        try {
            news.setNeid(UUID.randomUUID().toString());
            news.setNecreate(new Date());
            news.setUserid("1");// 获取值
            newsMapper.insertSelective(news);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }

        return news;
    }

    @Override
    public News modifyNews(News news) {

        try {
            newsMapper.updateByPrimaryKeySelective(news);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }

        return news;
    }

    @Override
    public News findById(String neid) {

        News news = null;
        try {
            news = newsMapper.selectByPrimaryKey(neid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }

        return news;
    }

    @Override
    public List<News> findByCategoryId(String categoryId) {

        List<News> news = null;
        try {
            NewsExample example = new NewsExample();
            example.createCriteria().andCategoryidEqualTo(categoryId);
            news = newsMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return news;
    }

    @Override
    public List<News> findByUserId(String userid) {

        List<News> news = null;
        try {
            NewsExample example = new NewsExample();
            example.createCriteria().andUseridEqualTo(userid);
            news = newsMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }

        return news;
    }

    @Override
    public List<News> findAll() {
        List<News> news = null;
        try {
            NewsExample example = new NewsExample();
            news = newsMapper.selectNewsUserCategory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return news;
    }

    @Override
    public Page<News> findByPage(Integer page, Integer rows) {
        Page<News> news = null;
        try {
            NewsExample example = new NewsExample();
            PageHelper.startPage(page , rows);
            news = (Page<News>) newsMapper.selectNewsUserCategory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return news;
    }

    @Override
    public Integer countNews() {
        int i = 0;
        try {
            i = newsMapper.countByExample(new NewsExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return i;
    }

    @Override
    public void removeNews(String id) {
        try {

            File file = new File(FileUploadUtil.getAbsolutePath() + newsMapper.selectByPrimaryKey(id).getNeimage());
            if(file.exists()){
                file.delete();
            }
            newsMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }

    }

    @Override
    public List<NewsComment> findAllComment(String neid) {

        List<NewsComment> newsComments = null;
        try {

            newsComments = newsCommentMapper.selectNewsCommentUser(neid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请稍后重试");
        }
        return newsComments;
    }
}

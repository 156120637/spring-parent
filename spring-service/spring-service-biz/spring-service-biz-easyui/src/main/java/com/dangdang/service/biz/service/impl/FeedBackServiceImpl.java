package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Feedback;
import com.dangdang.repository.mysql.mapper.easyui.entity.FeedbackExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.FeedbackMapper;
import com.dangdang.service.biz.service.FeedBackService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("feedBackService")
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 添加反馈信息
     *
     * @param feedback
     */
    @Override
    public void addFeedBack(Feedback feedback) {
        try {
            feedback.setFeid(UUID.randomUUID().toString());
            feedback.setFecreate(new Date());
            feedbackMapper.insertSelective(feedback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加出错,请稍后重试");
        }
    }

    /**
     * 查询所有的反馈信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Feedback> findAll() {

        List<Feedback> feedbacks = null;
        try {
            feedbacks = feedbackMapper.selectFeedBackUser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错了,请稍后重试");
        }
        return feedbacks;
    }

    @Override
    public Page<Feedback> findByPage(Integer page, Integer rows) {
        Page<Feedback> feedbacks = null;
        try {
            PageHelper.startPage(page , rows);
            feedbacks = (Page<Feedback>) feedbackMapper.selectFeedBackUser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错了,请稍后重试");
        }
        return feedbacks;
    }

    @Override
    public Integer countFeedBack() {
        int i = 0;
        try {
            i = feedbackMapper.countByExample(new FeedbackExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

        return i;
    }
}

package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Category;
import com.dangdang.repository.mysql.mapper.easyui.entity.CategoryExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.CategoryMapper;
import com.dangdang.service.biz.service.CategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category addCategory(Category category) {

        try {
            category.setCaid(UUID.randomUUID().toString());
            category.setCacreate(new Date());
            categoryMapper.insertSelective(category);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return category;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> findCategory(String carole) {
        List<Category> categorys = null;
        try {
            CategoryExample example = new CategoryExample();
            example.createCriteria().andCaroleEqualTo(carole);
            categorys = categoryMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return categorys;
    }

    @Override
    public void modifyCategory(Category category) {

        try {
            categoryMapper.updateByPrimaryKeySelective(category);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = null;
        try {
            CategoryExample example = new CategoryExample();
            categories = categoryMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return categories;

    }

    @Override
    public Page<Category> findByPage(Integer page, Integer rows) {
        Page<Category> categories = null;
        try {
            CategoryExample example = new CategoryExample();
            PageHelper.startPage(page , rows);
            categories = (Page<Category>) categoryMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return categories;
    }

    @Override
    public Integer countCategory() {

        int i = 0;
        try {
            i = categoryMapper.countByExample(new CategoryExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

        return i;
    }

    @Override
    public Category findById(String id) {

        Category category = null;
        try {
           category = categoryMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return category;
    }
}

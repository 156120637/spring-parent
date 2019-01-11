package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Category;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 分类相关的操作
 */
public interface CategoryService {

    /**
     * 添加分类
     * @param category
     * @return
     */
    public Category addCategory(Category category);

    /**
     * 查询所有分类 商品和资讯
     * @return
     */
    public List<Category> findCategory(String carole);


    /**
     * 修改分类信息
     * @param category
     */
    public void modifyCategory(Category category);

    /**
     * 查询所有
     * @return
     */
    public List<Category> findAll();

    /**
     * 分页查询
     * @param page  当前页
     * @param rows 每页显示的行数
     * @return
     */
    public Page<Category> findByPage(Integer page, Integer rows);

    /**
     * 统计个数
     * @return
     */
    public Integer countCategory();

    /**
     * 查询一条数据
     * @param id
     * @return
     */
    public Category findById(String id);

}

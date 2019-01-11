package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Carousel;

import java.util.List;

/**
 * 轮播图相关的操作
 */
public interface CarouselService {


    /**
     * 添加轮播图
     * @param carousel
     * @return
     */
    public Carousel addCarousel(Carousel carousel);

    /**
     * 修改轮播图
     * @param carousel
     * @return
     */
    public Carousel modifyCarousel(Carousel carousel);

    /**
     * 查询所有轮播图
     * @return
     */
    public List<Carousel> findAll();


    /**
     * 分页查询数据
     * @param page
     * @param rows
     * @return
     */
    public List<Carousel> findByPage(Integer page, Integer rows);

    /**
     * 统计个数
     * @return
     */
    public Integer countCarousel();

    /**
     * 查询一个
     * @param id
     * @return
     */
    public Carousel findById(String id);

    /**
     * 删除一个轮播图
     * @param id
     */
    public void removeCarousel(String id);

}

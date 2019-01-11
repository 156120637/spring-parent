package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Carousel;
import com.dangdang.repository.mysql.mapper.easyui.entity.CarouselExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.CarouselMapper;
import com.dangdang.service.biz.service.CarouselService;
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

@Service("carouselService")
@Transactional
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    @Override
    public Carousel addCarousel(Carousel carousel) {
        try {
            carousel.setCaid(UUID.randomUUID().toString());
            carousel.setCacreate(new Date());
            carouselMapper.insertSelective(carousel);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加出错了,请稍后重试");
        }
        return carousel;
    }

    @Override
    public Carousel modifyCarousel(Carousel carousel) {
        try {
            carouselMapper.updateByPrimaryKeySelective(carousel);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改出错,请稍后重试");
        }

        return carousel;
    }

    @Override
    public List<Carousel> findAll() {
        List<Carousel> carousels = null;
        try {
            carousels = carouselMapper.selectByExample(new CarouselExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错,请稍后重试");
        }
        return carousels;
    }

    @Override
    public List<Carousel> findByPage(Integer page, Integer rows) {
        Page<Carousel> carousels = null;
        try {
            PageHelper.startPage(page , rows);
            carousels = (Page<Carousel>) carouselMapper.selectByExample(new CarouselExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错,请稍后重试");
        }
        return carousels;
    }

    @Override
    public Integer countCarousel() {

        int i = 0;
        try {
            i = carouselMapper.countByExample(new CarouselExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

        return i;
    }

    @Override
    public Carousel findById(String id) {

        Carousel carousel = null;
        try {
            carousel = carouselMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

        return carousel;
    }

    @Override
    public void removeCarousel(String id) {

        try {
            Carousel byId = carouselMapper.selectByPrimaryKey(id);
            if(byId.getCaimage()!=null){
                File file = new File(FileUploadUtil.getResource()+byId.getCaimage());
                if(file.exists()){
                    file.delete();
                }// 删除文件
            }
            // 删除数据
            carouselMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

    }
}

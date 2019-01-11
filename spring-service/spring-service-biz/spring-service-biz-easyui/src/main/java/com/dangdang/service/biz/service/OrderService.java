package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Order;
import com.github.pagehelper.Page;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * order  订单相关的操作
 */
public interface OrderService {

    /**
     * 添加订单信息
     * @param order
     */
    public void addOrder(Order order);


    /**
     * 查询用户的订单信息
     * @param userid
     * @return
     */
    public List<Order> findByUserId(String userid);


    /**
     * 查询所有的订单
     * @return
     */
    public List<Order> findAll();

    /**
     * 分页查询
     * @param page
     * @param rows
     * @return
     */
    public Page<Order> findByPage(Integer page, Integer rows);

    /**
     * 统计条数
     * @return
     */
    public Integer countOrder();

    /**
     * 删除订单信息
     * @param orid
     */
    public void removeOrder(String orid);


    /**
     * 修改订单信息 -- 订单状态的修改
     * @param order
     */
    public void modifyOrder(Order order);

    /**
     * 查找一条数据
     * @param id
     * @return
     */
    public Order findById(String id);

    /**
     * 导出订单表
     */
    public XSSFWorkbook orderExcel();


}

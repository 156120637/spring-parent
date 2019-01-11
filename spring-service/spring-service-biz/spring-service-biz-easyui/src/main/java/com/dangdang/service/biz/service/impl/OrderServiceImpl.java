package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Order;
import com.dangdang.repository.mysql.mapper.easyui.entity.OrderExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.OrderMapper;
import com.dangdang.service.biz.service.OrderService;
import com.dangdang.common.utils.easyui.util.ExcelUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        try {
            order.setOrid(UUID.randomUUID().toString());
            order.setOrcreate(new Date());
            orderMapper.insertSelective(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

    }

    @Override
    public List<Order> findByUserId(String userid) {
        return null;
    }

    @Override
    public List<Order> findAll() {

        List<Order> orders = null;
        try {
            orders = orderMapper.selectOrderAddressUser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return orders;
    }

    @Override
    public Page<Order> findByPage(Integer page, Integer rows) {
        Page<Order> orders = null;
        try {
            PageHelper.startPage(page , rows);
            orders = (Page<Order>) orderMapper.selectOrderAddressUser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return orders;
    }

    @Override
    public Integer countOrder() {

        int i = 0;
        try {
            OrderExample example = new OrderExample();
            example.createCriteria().andOrpaystatusEqualTo(0);/*查询已经付款的*/
            i = orderMapper.countByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

        return i;
    }

    @Override
    public void removeOrder(String orid) {
        try {
            orderMapper.deleteByPrimaryKey(orid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
    }

    @Override
    public void modifyOrder(Order order) {
        try {
            orderMapper.updateByPrimaryKeySelective(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
    }

    @Override
    public Order findById(String id) {
        Order order = null;
        try {
            order = orderMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return order;
    }

    @Override
    public XSSFWorkbook orderExcel() {
        List<Order> list = orderMapper.selectOrderAddressUser();
        // 创建一个workbook 对应一个excel应用文件
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = workBook.createSheet("订单详情表");

        /*使用工具类设置样式*/
        ExcelUtil exportUtil = new ExcelUtil(workBook, sheet);
        XSSFCellStyle headStyle = exportUtil.getHeadStyle();
        XSSFCellStyle bodyStyle = exportUtil.getBodyStyle();

        // 构建表头
        XSSFRow headRow = sheet.createRow(0);
        XSSFCell cell = null;
        String[] titles = { "订单号", "创建日期", "用户名", "付款状态", "收件人",
                "收件地址", "收件人联系方式", "商品名称", "留言信息" };
        for (int i = 0; i < titles.length; i++)
        {
            cell = headRow.createCell(i);
            cell.setCellStyle(headStyle);
            cell.setCellValue(titles[i]);
        }

        // 构建表体数据
        if (list != null && list.size() > 0)
        {
            for (int j = 0; j < list.size(); j++)
            {
                XSSFRow bodyRow = sheet.createRow(j + 1);
                Order order = list.get(j);
                // 订单号
                cell = bodyRow.createCell(0);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getOrnumber());
                // 创建时间  转换时间格式
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String cratedata = format.format(order.getOrcreate());
                cell = bodyRow.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(cratedata);
                // 购买人
                cell = bodyRow.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getUser().getUsname());
                // 付款状态
                cell = bodyRow.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getOrpaystatus()==1?"未付款":"已付款");
                // 收货人姓名
                cell = bodyRow.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getAddress().getAdrecname());
                // 收货地址
                cell = bodyRow.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getAddress().getAddressdetail());
                // 收货人联系方式
                cell = bodyRow.createCell(6);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getAddress().getAdphone());
                // 商品名称
                cell = bodyRow.createCell(7);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getGoods().getGoname());
                // 留言信息
                cell = bodyRow.createCell(8);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(order.getOrmessage());

            }
        }
        sheet.autoSizeColumn(1);/*自适应列宽*/
        return workBook;
    }
}

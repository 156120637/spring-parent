package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Collect {
    private String scid;

    private String goodsid;

    private String shopid;

    private String userid;

    private Date sccreate;

    // 关系属性
    private Goods goods;
    private Shop shop;

}
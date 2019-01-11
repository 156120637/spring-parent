package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String orid;

    private Integer ornumber;

    private Date orcreate;

    private Integer orpaystatus;

    private String addressid;

    private String ormessage;

    // 关系属性
    private User user;
    private Address address;
    private Goods goods;
}
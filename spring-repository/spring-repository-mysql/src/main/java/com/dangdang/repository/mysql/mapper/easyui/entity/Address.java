package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
    private String adid;

    private String adrecname;

    private String adphone;

    private String adcode;

    private String addressdetail;

    private String cityid;

    private String userid;

    private Date adcreate;
}
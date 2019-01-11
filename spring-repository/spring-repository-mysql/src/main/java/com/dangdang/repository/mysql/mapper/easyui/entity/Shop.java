package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Shop implements Serializable {
    private String shid;

    private String shname;

    private Date shcreate;

    private String shimage;

    private String shdescribes;

    private String shcontact;

    private String shrole;

    private String shaddress;

    private String cityid;

}
package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Category implements Serializable {
    private String caid;

    private String caname;

    private Date cacreate;

    private String carole;

}
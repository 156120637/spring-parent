package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Feedback {
    private String feid;

    private String fecontent;

    private Date fecreate;

    private String userid;

    private String usenvironment;

    // 关系属性
    private User user;

}
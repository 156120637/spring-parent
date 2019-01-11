package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class News implements Serializable {
    private String neid;

    private String netitle;

    private String necontent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date necreate;

    private String neimage;

    private String neintro;

    private String userid;

    private String categoryid;

    // 关系属性
    private User user;
    private Category category;

    private NewsComment newsComment;

}
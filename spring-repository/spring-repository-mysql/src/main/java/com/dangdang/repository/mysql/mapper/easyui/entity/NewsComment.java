package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class NewsComment {
    private String ncoid;

    private String ncocontent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nccreate;

    private String userid;

    private String newsid;
    // 关系属性
    private News news;
    private User user;

}
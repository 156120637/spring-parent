package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class GoodsComment {
    private String gcoid;

    private String gcocontent;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gccreate;

    private String userid;

    private String goodsid;

    // 关系属性
    private Goods goods;
    private User user;

}
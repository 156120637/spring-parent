package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Goods implements Serializable {
    private String goid;

    private String goname;

    private Long goprice;

    private Long goshuprice;

    private Integer gosalescount;

    private String goimage;

    private Integer gostock;

    private Integer goviewcount;

    private String gonumber;

    private String goaddress;

    private String gosize;

    private String godescript;

    private String categoryid;

    private String shopid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gocreate;


    // 关系属性
    private Category category;
    private Shop shop;
    private List<GoodsComment> goodsComments;

}
package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class Cart {
    private String caid;

    private Integer cacount;

    private String goid;

    private String userid;

    private String orderid;

    private Integer orderstatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cacreate;

    private List<Goods> goods;

    public List<Goods> getGoods() {
        return goods;
    }

}
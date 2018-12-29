package com.dangdang.web.easyui.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

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

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid == null ? null : caid.trim();
    }

    public Integer getCacount() {
        return cacount;
    }

    public void setCacount(Integer cacount) {
        this.cacount = cacount;
    }

    public String getGoid() {
        return goid;
    }

    public void setGoid(String goid) {
        this.goid = goid == null ? null : goid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Date getCacreate() {
        return cacreate;
    }

    public void setCacreate(Date cacreate) {
        this.cacreate = cacreate;
    }
}
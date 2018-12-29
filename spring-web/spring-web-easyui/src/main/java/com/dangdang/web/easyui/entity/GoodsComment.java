package com.dangdang.web.easyui.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getGcoid() {
        return gcoid;
    }

    public void setGcoid(String gcoid) {
        this.gcoid = gcoid == null ? null : gcoid.trim();
    }

    public String getGcocontent() {
        return gcocontent;
    }

    public void setGcocontent(String gcocontent) {
        this.gcocontent = gcocontent == null ? null : gcocontent.trim();
    }

    public Date getGccreate() {
        return gccreate;
    }

    public void setGccreate(Date gccreate) {
        this.gccreate = gccreate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }
}
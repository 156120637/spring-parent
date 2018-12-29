package com.dangdang.web.easyui.entity;

import java.util.Date;

public class Collect {
    private String scid;

    private String goodsid;

    private String shopid;

    private String userid;

    private Date sccreate;

    // 关系属性
    private Goods goods;
    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Goods getGoods() {

        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid == null ? null : scid.trim();
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid == null ? null : shopid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getSccreate() {
        return sccreate;
    }

    public void setSccreate(Date sccreate) {
        this.sccreate = sccreate;
    }
}
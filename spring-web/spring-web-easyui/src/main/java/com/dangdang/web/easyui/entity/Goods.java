package com.dangdang.web.easyui.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    public List<GoodsComment> getGoodsComments() {
        return goodsComments;
    }

    public void setGoodsComments(List<GoodsComment> goodsComments) {
        this.goodsComments = goodsComments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getGoid() {
        return goid;
    }

    public void setGoid(String goid) {
        this.goid = goid == null ? null : goid.trim();
    }

    public String getGoname() {
        return goname;
    }

    public void setGoname(String goname) {
        this.goname = goname == null ? null : goname.trim();
    }

    public Long getGoprice() {
        return goprice;
    }

    public void setGoprice(Long goprice) {
        this.goprice = goprice;
    }

    public Long getGoshuprice() {
        return goshuprice;
    }

    public void setGoshuprice(Long goshuprice) {
        this.goshuprice = goshuprice;
    }

    public Integer getGosalescount() {
        return gosalescount;
    }

    public void setGosalescount(Integer gosalescount) {
        this.gosalescount = gosalescount;
    }

    public String getGoimage() {
        return goimage;
    }

    public void setGoimage(String goimage) {
        this.goimage = goimage == null ? null : goimage.trim();
    }

    public Integer getGostock() {
        return gostock;
    }

    public void setGostock(Integer gostock) {
        this.gostock = gostock;
    }

    public Integer getGoviewcount() {
        return goviewcount;
    }

    public void setGoviewcount(Integer goviewcount) {
        this.goviewcount = goviewcount;
    }

    public String getGonumber() {
        return gonumber;
    }

    public void setGonumber(String gonumber) {
        this.gonumber = gonumber == null ? null : gonumber.trim();
    }

    public String getGoaddress() {
        return goaddress;
    }

    public void setGoaddress(String goaddress) {
        this.goaddress = goaddress == null ? null : goaddress.trim();
    }

    public String getGosize() {
        return gosize;
    }

    public void setGosize(String gosize) {
        this.gosize = gosize == null ? null : gosize.trim();
    }

    public String getGodescript() {
        return godescript;
    }

    public void setGodescript(String godescript) {
        this.godescript = godescript == null ? null : godescript.trim();
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid == null ? null : shopid.trim();
    }

    public Date getGocreate() {
        return gocreate;
    }

    public void setGocreate(Date gocreate) {
        this.gocreate = gocreate;
    }
}
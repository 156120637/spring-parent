package com.dangdang.web.easyui.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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

    public NewsComment getNewsComment() {
        return newsComment;
    }

    public void setNewsComment(NewsComment newsComment) {
        this.newsComment = newsComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNeid() {
        return neid;
    }

    public void setNeid(String neid) {
        this.neid = neid == null ? null : neid.trim();
    }

    public String getNetitle() {
        return netitle;
    }

    public void setNetitle(String netitle) {
        this.netitle = netitle == null ? null : netitle.trim();
    }

    public String getNecontent() {
        return necontent;
    }

    public void setNecontent(String necontent) {
        this.necontent = necontent == null ? null : necontent.trim();
    }

    public Date getNecreate() {
        return necreate;
    }

    public void setNecreate(Date necreate) {
        this.necreate = necreate;
    }

    public String getNeimage() {
        return neimage;
    }

    public void setNeimage(String neimage) {
        this.neimage = neimage == null ? null : neimage.trim();
    }

    public String getNeintro() {
        return neintro;
    }

    public void setNeintro(String neintro) {
        this.neintro = neintro == null ? null : neintro.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }
}
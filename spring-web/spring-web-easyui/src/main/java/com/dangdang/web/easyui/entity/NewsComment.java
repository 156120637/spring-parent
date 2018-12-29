package com.dangdang.web.easyui.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getNcoid() {
        return ncoid;
    }

    public void setNcoid(String ncoid) {
        this.ncoid = ncoid == null ? null : ncoid.trim();
    }

    public String getNcocontent() {
        return ncocontent;
    }

    public void setNcocontent(String ncocontent) {
        this.ncocontent = ncocontent == null ? null : ncocontent.trim();
    }

    public Date getNccreate() {
        return nccreate;
    }

    public void setNccreate(Date nccreate) {
        this.nccreate = nccreate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid == null ? null : newsid.trim();
    }
}
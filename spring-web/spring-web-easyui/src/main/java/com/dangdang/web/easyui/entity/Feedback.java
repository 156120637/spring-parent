package com.dangdang.web.easyui.entity;

import java.util.Date;

public class Feedback {
    private String feid;

    private String fecontent;

    private Date fecreate;

    private String userid;

    private String usenvironment;

    // 关系属性
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFeid() {
        return feid;
    }

    public void setFeid(String feid) {
        this.feid = feid == null ? null : feid.trim();
    }

    public String getFecontent() {
        return fecontent;
    }

    public void setFecontent(String fecontent) {
        this.fecontent = fecontent == null ? null : fecontent.trim();
    }

    public Date getFecreate() {
        return fecreate;
    }

    public void setFecreate(Date fecreate) {
        this.fecreate = fecreate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsenvironment() {
        return usenvironment;
    }

    public void setUsenvironment(String usenvironment) {
        this.usenvironment = usenvironment == null ? null : usenvironment.trim();
    }
}
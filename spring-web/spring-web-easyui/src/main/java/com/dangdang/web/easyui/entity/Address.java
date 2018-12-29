package com.dangdang.web.easyui.entity;

import java.util.Date;

public class Address {
    private String adid;

    private String adrecname;

    private String adphone;

    private String adcode;

    private String addressdetail;

    private String cityid;

    private String userid;

    private Date adcreate;

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid == null ? null : adid.trim();
    }

    public String getAdrecname() {
        return adrecname;
    }

    public void setAdrecname(String adrecname) {
        this.adrecname = adrecname == null ? null : adrecname.trim();
    }

    public String getAdphone() {
        return adphone;
    }

    public void setAdphone(String adphone) {
        this.adphone = adphone == null ? null : adphone.trim();
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode == null ? null : adcode.trim();
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail == null ? null : addressdetail.trim();
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getAdcreate() {
        return adcreate;
    }

    public void setAdcreate(Date adcreate) {
        this.adcreate = adcreate;
    }
}
package com.dangdang.web.easyui.entity;

import java.io.Serializable;
import java.util.Date;

public class Shop implements Serializable {
    private String shid;

    private String shname;

    private Date shcreate;

    private String shimage;

    private String shdescribes;

    private String shcontact;

    private String shrole;

    private String shaddress;

    private String cityid;

    public String getShid() {
        return shid;
    }

    public void setShid(String shid) {
        this.shid = shid == null ? null : shid.trim();
    }

    public String getShname() {
        return shname;
    }

    public void setShname(String shname) {
        this.shname = shname == null ? null : shname.trim();
    }

    public Date getShcreate() {
        return shcreate;
    }

    public void setShcreate(Date shcreate) {
        this.shcreate = shcreate;
    }

    public String getShimage() {
        return shimage;
    }

    public void setShimage(String shimage) {
        this.shimage = shimage == null ? null : shimage.trim();
    }

    public String getShdescribes() {
        return shdescribes;
    }

    public void setShdescribes(String shdescribes) {
        this.shdescribes = shdescribes == null ? null : shdescribes.trim();
    }

    public String getShcontact() {
        return shcontact;
    }

    public void setShcontact(String shcontact) {
        this.shcontact = shcontact == null ? null : shcontact.trim();
    }

    public String getShrole() {
        return shrole;
    }

    public void setShrole(String shrole) {
        this.shrole = shrole == null ? null : shrole.trim();
    }

    public String getShaddress() {
        return shaddress;
    }

    public void setShaddress(String shaddress) {
        this.shaddress = shaddress == null ? null : shaddress.trim();
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }
}
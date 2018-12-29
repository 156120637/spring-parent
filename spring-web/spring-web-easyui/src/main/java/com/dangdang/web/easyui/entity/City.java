package com.dangdang.web.easyui.entity;

import java.io.Serializable;

public class City implements Serializable {
    private String ciid;

    private String ciname;

    private String cityid;

    public String getCiid() {
        return ciid;
    }

    public void setCiid(String ciid) {
        this.ciid = ciid == null ? null : ciid.trim();
    }

    public String getCiname() {
        return ciname;
    }

    public void setCiname(String ciname) {
        this.ciname = ciname == null ? null : ciname.trim();
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }
}
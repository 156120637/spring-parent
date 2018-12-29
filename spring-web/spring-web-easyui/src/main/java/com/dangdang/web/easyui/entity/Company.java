package com.dangdang.web.easyui.entity;

public class Company {
    private String coid;

    private String coabout;

    private String coconnect;

    private String coidentification;

    private String coother;

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    public String getCoabout() {
        return coabout;
    }

    public void setCoabout(String coabout) {
        this.coabout = coabout == null ? null : coabout.trim();
    }

    public String getCoconnect() {
        return coconnect;
    }

    public void setCoconnect(String coconnect) {
        this.coconnect = coconnect == null ? null : coconnect.trim();
    }

    public String getCoidentification() {
        return coidentification;
    }

    public void setCoidentification(String coidentification) {
        this.coidentification = coidentification == null ? null : coidentification.trim();
    }

    public String getCoother() {
        return coother;
    }

    public void setCoother(String coother) {
        this.coother = coother == null ? null : coother.trim();
    }
}
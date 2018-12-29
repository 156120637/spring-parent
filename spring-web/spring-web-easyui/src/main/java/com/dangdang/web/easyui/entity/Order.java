package com.dangdang.web.easyui.entity;

import java.util.Date;

public class Order {
    private String orid;

    private Integer ornumber;

    private Date orcreate;

    private Integer orpaystatus;

    private String addressid;

    private String ormessage;

    // 关系属性
    private User user;
    private Address address;
    private Goods goods;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getOrid() {
        return orid;
    }

    public void setOrid(String orid) {
        this.orid = orid == null ? null : orid.trim();
    }

    public Integer getOrnumber() {
        return ornumber;
    }

    public void setOrnumber(Integer ornumber) {
        this.ornumber = ornumber;
    }

    public Date getOrcreate() {
        return orcreate;
    }

    public void setOrcreate(Date orcreate) {
        this.orcreate = orcreate;
    }

    public Integer getOrpaystatus() {
        return orpaystatus;
    }

    public void setOrpaystatus(Integer orpaystatus) {
        this.orpaystatus = orpaystatus;
    }

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid == null ? null : addressid.trim();
    }

    public String getOrmessage() {
        return ormessage;
    }

    public void setOrmessage(String ormessage) {
        this.ormessage = ormessage == null ? null : ormessage.trim();
    }
}
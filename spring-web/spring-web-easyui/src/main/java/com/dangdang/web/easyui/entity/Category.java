package com.dangdang.web.easyui.entity;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private String caid;

    private String caname;

    private Date cacreate;

    private String carole;

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid == null ? null : caid.trim();
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname == null ? null : caname.trim();
    }

    public Date getCacreate() {
        return cacreate;
    }

    public void setCacreate(Date cacreate) {
        this.cacreate = cacreate;
    }

    public String getCarole() {
        return carole;
    }

    public void setCarole(String carole) {
        this.carole = carole == null ? null : carole.trim();
    }
}
package com.dangdang.web.easyui.entity;

import java.util.Date;

public class Carousel {
    private String caid;

    private Date cacreate;

    private String caname;

    private String caimage;

    public String getCaid() {
        return caid;
    }

    public void setCaid(String caid) {
        this.caid = caid == null ? null : caid.trim();
    }

    public Date getCacreate() {
        return cacreate;
    }

    public void setCacreate(Date cacreate) {
        this.cacreate = cacreate;
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname == null ? null : caname.trim();
    }

    public String getCaimage() {
        return caimage;
    }

    public void setCaimage(String caimage) {
        this.caimage = caimage == null ? null : caimage.trim();
    }
}
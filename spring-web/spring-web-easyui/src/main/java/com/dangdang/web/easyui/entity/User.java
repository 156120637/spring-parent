package com.dangdang.web.easyui.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String usid;

    private String usname;

    private String uspassword;

    private String ussalt;

    private String usphone;

    private String usstatus;

    private String usrole;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date uscreate;

    public String getUsid() {
        return usid;
    }

    public void setUsid(String usid) {
        this.usid = usid == null ? null : usid.trim();
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname == null ? null : usname.trim();
    }

    public String getUspassword() {
        return uspassword;
    }

    public void setUspassword(String uspassword) {
        this.uspassword = uspassword == null ? null : uspassword.trim();
    }

    public String getUssalt() {
        return ussalt;
    }

    public void setUssalt(String ussalt) {
        this.ussalt = ussalt == null ? null : ussalt.trim();
    }

    public String getUsphone() {
        return usphone;
    }

    public void setUsphone(String usphone) {
        this.usphone = usphone == null ? null : usphone.trim();
    }

    public String getUsstatus() {
        return usstatus;
    }

    public void setUsstatus(String usstatus) {
        this.usstatus = usstatus == null ? null : usstatus.trim();
    }

    public String getUsrole() {
        return usrole;
    }

    public void setUsrole(String usrole) {
        this.usrole = usrole == null ? null : usrole.trim();
    }

    public Date getUscreate() {
        return uscreate;
    }

    public void setUscreate(Date uscreate) {
        this.uscreate = uscreate;
    }
}
package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
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

}
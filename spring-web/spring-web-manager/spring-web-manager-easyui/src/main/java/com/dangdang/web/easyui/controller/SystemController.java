package com.dangdang.web.easyui.controller;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.Company;
import com.dangdang.service.biz.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/system")
public class SystemController {


    @Autowired
    private SystemService systemService;


    /**
     * 查询信息
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(){
        List<Company> companies = systemService.findAll();
        String s = JSONObject.toJSONStringWithDateFormat(companies, "yyyy-MM-dd");
        return s;
    }

    /**
     * 查询一条数据
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") String id , Model model){

        Company byId = systemService.findById(id);
        model.addAttribute("company" , byId);
        return "system/systemupdate";
    }

    /**
     * 修改公司信息
     * @param company
     */
    @RequestMapping("/modifySystem")
    @ResponseBody
    public void modifySystem(Company company){
        systemService.modifyCompany(company);
    }


    /**
     * 跳转界面
     * @return
     */
    @RequestMapping({"/system.htm", "/system"})
    public String toSystem(){
        return "system/system";
    }


}

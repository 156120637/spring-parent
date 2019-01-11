package com.dangdang.web.easyui.controller;

import com.alibaba.fastjson.JSONObject;
import com.dangdang.repository.mysql.mapper.easyui.entity.Feedback;
import com.dangdang.service.biz.service.FeedBackService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/feedback")
public class FeedBackController {


    @Autowired
    private FeedBackService feedBackService;


    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false , defaultValue = "1")Integer page ,
                          @RequestParam(required = false, defaultValue = "10")Integer rows){
        Page<Feedback> byPage = feedBackService.findByPage(page, rows);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", byPage);
        jsonObject.put("total", feedBackService.countFeedBack());
        String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd");
        return s;
    }


    @RequestMapping({"/feedback.htm", "/feedback"})
    public String toFeedBack(){
        return "feedback/backlist";
    }

}

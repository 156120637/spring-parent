package com.dangdang.web.easyui.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by tianjiaqin 2018/12/28-11-16
 */
@Api(description = "easyui+thymeleaf使用")
@Controller
public class IndexController {

    @ApiOperation(value = "请求名称", notes = "节点名称", httpMethod = "GET")
    @RequestMapping("/toIndex.htm")
    public String toIndex(){
        return "index";
    }


}

package com.dangdang.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tianjiaqin 2018-12-07
 */
@RestController
public class IndexController {

    @RequestMapping({"/index.htm", "index"})
    public String index(){
        return "index";
    }

}

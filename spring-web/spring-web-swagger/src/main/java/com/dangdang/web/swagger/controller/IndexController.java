package com.dangdang.web.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tianjiaqin 2018-12-13
 */
@Slf4j
@Api(description = "swagger使用方法")
@RestController
public class IndexController {

    @ApiOperation(value = "请求名称", notes = "节点名称", httpMethod = "GET")
    @RequestMapping("/swaggerGet")
    public String swaggerGet(String id) {
        if (StringUtils.isNotBlank(id)) {
            log.info("param is {}", id);
        }else {
            log.error("param is blank {}", id);
        }
        return "SUCCESS";
    }

}

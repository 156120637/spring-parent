package com.dangdang.web.controller;

import com.dangdang.common.exception.BaseException;
import com.dangdang.common.utils.ValidateUtils;
import com.dangdang.common.utils.controller.BaseController;
import com.dangdang.service.biz.dto.BaseForm;
import com.dangdang.service.biz.service.AspectJService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by tianjiaqin 2019-04-14
 */
@Slf4j
@Api("aspectJ的使用")
@RestController
@RequestMapping(value = "/aspectj")
public class AspectJController extends BaseController {

    @Autowired
    private ValidateUtils validateUtils;


    @Autowired
    private AspectJService aspectJService;


    @ApiOperation(value = "切面测试", notes = "切面", httpMethod = "POST")
    @RequestMapping(value = {"/base"} , method = RequestMethod.POST)
    public Object aspectJBase(HttpServletRequest request, BaseForm baseForm , BindingResult result) throws BaseException {
        validateUtils.check(request,baseForm , BaseForm.class , result);
        return this.success(aspectJService.base());
    }

    @ApiOperation(value = "切面测试", notes = "切面", httpMethod = "POST")
    @RequestMapping(value = {"/ano"} , method = RequestMethod.POST)
    public Object annoAspectJBase(HttpServletRequest request, BaseForm baseForm , BindingResult result) throws BaseException {
        validateUtils.check(request,baseForm , BaseForm.class , result);
        return this.success(aspectJService.annoBase());
    }

}

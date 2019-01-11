package com.dangdang.web.easyui.exception;

import com.dangdang.common.enums.HttpResponseErrorCodeEnum;
import com.dangdang.common.enums.HttpResponseStatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by tianjiaqin 2018-12-13
 */
@Slf4j
@ControllerAdvice
public class GloableExceptionHandler {

    /**
     * 参数异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> exceptionHandler(Exception e){
        log.error("gloable exception handler  , exception {}" , e);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Map<String, Object> result = new HashMap<>();
        result.put("errorCode", HttpResponseErrorCodeEnum.HTTP_ERROR_CODE_FAIL.getType());
        result.put("statusCode", HttpResponseStatusCodeEnum.HTTP_STATUS_CODE_SYSTEM.getType());
        result.put("statusMsg", HttpResponseStatusCodeEnum.HTTP_STATUS_CODE_SYSTEM.getDesc());
        stopWatch.stop();
        result.put("responseTime", stopWatch.getTotalTimeMillis());
        log.info("GlobalExceptionHandler has intercept ,response result is {} ", result);
        return  result;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}

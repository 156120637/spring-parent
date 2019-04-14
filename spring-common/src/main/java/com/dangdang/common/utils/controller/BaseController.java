package com.dangdang.common.utils.controller;

import com.dangdang.common.enums.BaseCodeEnum;
import com.dangdang.common.exception.BaseException;
import com.dangdang.common.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 所有Controller的基类，其他Controller继承这个类.
 * 类中包含统一的成功数据响应封装方法. 也包括其他处理错误响应的方法. 其他子类只要抛出异常即可.
 */
@Slf4j
@ApiIgnore
@RestController
public class BaseController {

    protected static final int SUCCESS_CODE = 0;
    protected static final int FAIL_CODE = 1;

    protected Object result(Object obj) {
        LogUtils.resultLog(obj);
        return obj;
    }

    protected Response success() {
        Response response = new Response();
        response.setErrorCode(SUCCESS_CODE);
        response.setStatusCode(BaseCodeEnum.BASE_REQUEST_SUCCESS.getCode());
        response.setStatusMsg(BaseCodeEnum.BASE_REQUEST_SUCCESS.getMsg());
        // 耗时时间
        response.setCostTime(LogUtils.getTimeCost());

        LogUtils.resultLog(response);
        return response;
    }

    protected Response success(Object obj) {
        Response response = new Response();
        response.setErrorCode(SUCCESS_CODE);
        response.setStatusCode(BaseCodeEnum.BASE_REQUEST_SUCCESS.getCode());
        response.setStatusMsg(BaseCodeEnum.BASE_REQUEST_SUCCESS.getMsg());
        // 耗时时间
        response.setCostTime(LogUtils.getTimeCost());
        response.setData(obj);

        LogUtils.resultLog(response);
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Response handleGoodsException(BaseException exception) {
        log.error("error code [{}]", exception.getCode());
        log.error("error exception {}", exception);

        Response response = new Response();
        response.setErrorCode(FAIL_CODE);
        response.setStatusCode(exception.getCode());
        response.setStatusMsg(exception.getMessage());
        // 耗时时间
        response.setCostTime(LogUtils.getTimeCost());

        LogUtils.resultLog(response);
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Response handleGoodsException(RuntimeException exception) {
        log.error("error exception {}", exception);

        Response response = new Response();
        response.setErrorCode(FAIL_CODE);
        response.setStatusCode(BaseCodeEnum.BASE_SYSTEM_ERROR.getCode());
        response.setStatusMsg(exception.getMessage());
        // 耗时时间
        response.setCostTime(LogUtils.getTimeCost());

        LogUtils.resultLog(response);
        return response;
    }


    /**
     *  请求方法错误  405 - Method Not Allowed
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error("http method not support {}", exception);
        Response response = new Response();
        response.setErrorCode(FAIL_CODE);
        response.setStatusCode(BaseCodeEnum.BASE_SYSTEM_ERROR.getCode());
        response.setStatusMsg(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
        // 耗时时间
        response.setCostTime(LogUtils.getTimeCost());

        LogUtils.resultLog(response);
        return response;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response handleHttpMediaTypeNotSupportedException(Exception exception) {
        log.error("http media type not support {}", exception);
        Response response = new Response();
        response.setErrorCode(FAIL_CODE);
        response.setStatusCode(BaseCodeEnum.BASE_SYSTEM_ERROR.getCode());
        response.setStatusMsg(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
        // 耗时时间
        response.setCostTime(LogUtils.getTimeCost());

        LogUtils.resultLog(response);
        return response;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception exception) {
        log.error("exception has occer {}", exception);
        Response response = new Response();
        response.setErrorCode(FAIL_CODE);
        response.setStatusCode(BaseCodeEnum.BASE_SYSTEM_ERROR.getCode());
        response.setStatusMsg(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
        // 耗时时间
        response.setCostTime(LogUtils.getTimeCost());
        LogUtils.resultLog(response);
        return response;
    }
    /**
     * 除此之外还可以捕捉自定义异常 ，比如在service中抛出一个异常，@ExceptionHandler(BaseServiceException.class) 进行自定义处理。
     * 更详细的的还可以点进去HttpStatus中查看详细的枚举类型。
     *
     */
}

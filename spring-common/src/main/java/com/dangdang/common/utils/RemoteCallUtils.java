package com.dangdang.common.utils;


import com.alibaba.fastjson.JSONObject;
import com.dangdang.common.enums.BaseCodeEnum;
import com.dangdang.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Create by tianjiaqin 2018/11/12
 */
@Slf4j
@Component
public class RemoteCallUtils {


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {

//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        // 设置超时 10s
//        requestFactory.setConnectTimeout(10000);
//        requestFactory.setReadTimeout(10000);

        RestTemplate restTemplate = new RestTemplate();

        // 使用utf-8字符集
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        return restTemplate;
    }

    private HttpEntity<String> getJsonHttpEntity(Object obj) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return new HttpEntity<>(JSONUtils.objToStr(obj), headers);
    }

    /**
     * pos请求
     * 参数为json传输
     *
     * @param url
     * @param param
     * @param isJson 请求是否要求为json格式 true:是；false:否
     * @return
     */
    public String post(String url, Object param, boolean isJson) {

        log.info("call the third post service request url. {}", url);
        log.info("call the third post service request params. {}", JSONUtils.objToStr(param, true));
        String result = null;
        if (isJson) {
            HttpEntity<String> formEntity = getJsonHttpEntity(param);
            result = restTemplate.postForObject(url, formEntity, String.class);
        } else {
            result = restTemplate.postForObject(UrlUtils.urlParams(url, param), "", String.class);
        }
        log.info("call the third post service return data. {}", result);

        return result;
    }

    /**
     * post请求
     *
     * @param url
     * @param param
     * @return
     */
    public String postByMap(String url, Map<String, Object> param) {

        log.info("call the third post service request url.{}", url);
        log.info("call the third post service request params.{}", JSONUtils.objToStr(param, true));
        String result = restTemplate.postForObject(UrlUtils.urlMapParams(url, param), "", String.class);
        log.info("call the third post service return data.{}", result);

        return result;
    }
    /**
     * get请求
     *
     * @param url
     * @param param
     * @return
     */
    public String get(String url, Object param) {

        log.info("call the third get service request url.{}", url);
        log.info("call the third get service request params.{}", JSONUtils.objToStr(param, true));
        String result = restTemplate.getForObject(UrlUtils.urlParams(url, param), String.class);
        log.info("call the third get service return data.{}", result);

        return result;
    }

    /**
     * get请求
     *
     * @param url
     * @param param
     * @return
     */
    public String getByMap(String url, Map<String, Object> param) {

        log.info("call the third get service request url.{}", url);
        log.info("call the third get service request params.{}", JSONUtils.objToStr(param, true));
        String result = restTemplate.getForObject(UrlUtils.urlMapParams(url, param), String.class);
        log.info("call the third get service return data.{}", result);

        return result;
    }

    /**
     * post 发送 application/x-www-form-urlencoded
     * @param url
     * @param param
     * @return
     */
    public String postByMapFormData(String url, Map<String, Object> param){
        MultiValueMap<String, Object> mparam = new LinkedMultiValueMap<>();
        param.forEach((k, v) -> {
            if(v == null){
                mparam.set(k, "");
            } else {
                mparam.set(k, v.toString());
            }
        });
        log.info("call the third get service request url.{}", url);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<MultiValueMap<String, Object>> params = new HttpEntity<>(mparam, headers);
        String result = restTemplate.postForObject(url, params, String.class);
        log.info("call the third get service return data.{}", result);
        return result;
    }
    /**
     * get请求
     * 参数json串作为占位符处理
     *
     * @param url
     * @param param
     * @return
     */
    public String getByJson(String url, String param) {

        log.info("call the third get service request url.{}", url);
        log.info("call the third get service request params.{}", JSONUtils.objToStr(param, true));
        String result = restTemplate.getForObject(url, String.class, param);
        log.info("call the third get service return data.{}", result);

        return result;
    }

    private String getResult(String result) throws BaseException {

        if (StringUtils.isBlank(result)) {
            throw new BaseException(BaseCodeEnum.THIRD_RETURN_DATA_EMPTY_ERROR.getCode(), BaseCodeEnum.THIRD_RETURN_DATA_EMPTY_ERROR.getMsg());
        }

        JSONObject jsonObj = JSONObject.parseObject(result);
        if (null != jsonObj) {
            Integer code = jsonObj.getInteger("errorCode");
            if (code.equals(0)) {
                String data = JSONUtils.objToStr(jsonObj.get("extra"), true);
                if (StringUtils.isBlank(data) || "{}".equals(data) || "[]".equals(data)) {
                    return null;
                }
                return data;
            }
            String msg = jsonObj.getString("errorMessage");
            throw new BaseException(code, msg);
        }
        throw new BaseException(BaseCodeEnum.THIRD_CALL_EXCEPTION_ERROR.getCode(), BaseCodeEnum.THIRD_CALL_EXCEPTION_ERROR.getMsg());

    }

}

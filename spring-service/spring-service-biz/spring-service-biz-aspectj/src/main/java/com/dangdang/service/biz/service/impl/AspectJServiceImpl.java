package com.dangdang.service.biz.service.impl;

import com.dangdang.service.biz.anno.AnnoInterfaceAspectJ;
import com.dangdang.service.biz.service.AspectJService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Create by tianjiaqin 2019/4/12-22-48
 */
@Slf4j
@Component
public class AspectJServiceImpl implements AspectJService {


    @Override
    public String base() {
        log.info("aspectJ service ....");
        return null;
    }

    @Override
    @AnnoInterfaceAspectJ(description = "自定义注解 aspectJ")
    public String annoBase(){
        
        return null;
        
    }
}

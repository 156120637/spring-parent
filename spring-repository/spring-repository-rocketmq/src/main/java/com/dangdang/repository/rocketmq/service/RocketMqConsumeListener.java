package com.dangdang.repository.rocketmq.service;//package com.dangdang.storage.rocketmq.service;

import com.dangdang.repository.rocketmq.config.RocketMqEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

/**
 * Created by tianjiaqin on 2018-12-7
 */
@Slf4j
//@Component  //使用例子，如果要使用Listener，将这个类copy到需要的目录下，去掉Component的注释即可使用.
public class RocketMqConsumeListener {
    @EventListener
    public void testConsumer(RocketMqEvent event){
        String msg = new String(event.getMsgs().get(0).getBody());
        log.info(msg);
    }
}

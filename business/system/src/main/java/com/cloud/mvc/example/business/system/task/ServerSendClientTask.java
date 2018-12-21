package com.cloud.mvc.example.business.system.task;

import com.cloud.mvc.example.business.common.config.refresh.RefreshBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RefreshScope
public class ServerSendClientTask {

    private static final Logger logger = LoggerFactory.getLogger(ServerSendClientTask.class);


    @Autowired
    RefreshBean refreshBean;


//    @Scheduled(fixedDelay = ONE_SECOND)
    public void aciton(){
        logger.debug("开始执行定时任务：{}", LocalDateTime.now());
        logger.debug("bean:{}", refreshBean.toString());
        logger.debug("定时任务执行完成;");
    }



}

package com.cloud.mvc.example.business.system.task;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.system.controller.DeferedResultController;
import com.google.common.collect.Multimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import static javax.management.timer.Timer.ONE_SECOND;

@Component
public class ServerSendClientTask {

    private static final Logger logger = LoggerFactory.getLogger(ServerSendClientTask.class);

//    @Scheduled(fixedDelay = ONE_SECOND)
    public void aciton(){
        Multimap<Integer, DeferredResult<Resp>> map = DeferedResultController.map;
        logger.debug("开始执行定时任务，当前客户端的数量={}", map.size());
        map.entries().stream()
                .forEach(t -> {
                    final Integer id = t.getKey();
                    final DeferredResult<Resp> result = t.getValue();
                    result.setResult(Resp.success("服务器成功发送数据到客户端，客户端id=" + id));
                });
    }



}

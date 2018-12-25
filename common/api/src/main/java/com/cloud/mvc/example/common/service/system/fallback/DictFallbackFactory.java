package com.cloud.mvc.example.common.service.system.fallback;

import com.cloud.mvc.example.business.domain.dto.system.DictDto;
import com.cloud.mvc.example.common.service.system.client.SystemDictServiceClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DictFallbackFactory implements FallbackFactory<SystemDictServiceClient> {
    @Override
    public SystemDictServiceClient create(Throwable throwable) {

        return new SystemDictServiceClient() {
            @Override
            public DictDto findDictByKey(String key) {
                logger.error("查询常量信息出现异常：", throwable);
                throw new RuntimeException(throwable);
            }
        };
    }


    private static final Logger logger = LoggerFactory.getLogger(DictFallbackFactory.class);


}

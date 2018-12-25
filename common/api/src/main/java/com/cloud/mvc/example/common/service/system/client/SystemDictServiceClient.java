package com.cloud.mvc.example.common.service.system.client;

import com.cloud.mvc.example.common.service.common.SystemFeignClient;
import com.cloud.mvc.example.common.service.system.ISystemDictService;
import com.cloud.mvc.example.common.service.system.fallback.DictFallbackFactory;

@SystemFeignClient(path = SystemDictServiceClient.path, fallbackFactory = DictFallbackFactory.class)
public interface SystemDictServiceClient extends ISystemDictService {
}

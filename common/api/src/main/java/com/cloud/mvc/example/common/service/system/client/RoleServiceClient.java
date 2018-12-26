package com.cloud.mvc.example.common.service.system.client;

import com.cloud.mvc.example.common.service.common.SystemFeignClient;
import com.cloud.mvc.example.common.service.system.IRoleService;

@SystemFeignClient(path = RoleServiceClient.path)
public interface RoleServiceClient extends IRoleService {
}

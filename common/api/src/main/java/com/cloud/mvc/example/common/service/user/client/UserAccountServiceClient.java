package com.cloud.mvc.example.common.service.user.client;

import com.cloud.mvc.example.common.service.common.UserFeignClient;
import com.cloud.mvc.example.common.service.user.IUserAccountService;


@UserFeignClient(path = UserAccountServiceClient.path)
public interface UserAccountServiceClient extends IUserAccountService {
}

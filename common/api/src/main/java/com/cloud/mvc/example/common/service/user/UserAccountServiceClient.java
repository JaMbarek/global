package com.cloud.mvc.example.common.service.user;

import com.cloud.mvc.example.common.service.common.UserFeignClient;


@UserFeignClient(path = UserAccountServiceClient.path)
public interface UserAccountServiceClient extends IUserAccountService {
}

package com.cloud.mvc.example.common.service.user;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user", path = "/account")
public interface UserAccountServiceClient extends IUserAccountService {
}

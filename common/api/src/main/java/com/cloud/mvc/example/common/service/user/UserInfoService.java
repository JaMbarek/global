package com.cloud.mvc.example.common.service.user;

import com.cloud.mvc.example.business.domain.entity.user.UserInfo;

import java.util.List;

public interface UserInfoService {


    UserInfo getUserInfo(Long id);

    List<UserInfo> getAll();

    List<UserInfo> getUserInfoByIds(List<Long> ids);


}

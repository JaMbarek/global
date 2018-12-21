package com.cloud.mvc.example.business.common.config.security.filters;


import com.cloud.mvc.example.business.common.config.security.beans.UserLoginDto;

import javax.servlet.http.HttpServletRequest;


/**
 * 验证用户的登录信息接口
 * 当添加别的验证时只需要实现改接口并且配置即可
 * @see FiltersConfig
 */
@FunctionalInterface
public interface UserLoginFilter {


    void validate(UserLoginDto dto, HttpServletRequest request);



}

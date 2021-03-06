package com.cloud.mvc.example.business.common.config.security.filters;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.domain.exceptions.user.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Optional;

import static com.cloud.mvc.example.business.common.config.message.CommonCodeAndMessage.LOGIN_INFO_NULL;
import static com.cloud.mvc.example.business.common.config.message.CommonCodeAndMessage.VERIFY_CODE_ERROR;

/**
 * 验证用户的登录信息配置类
 */
@Configuration
public class FiltersConfig {

    private static final Logger logger = LoggerFactory.getLogger(FiltersConfig.class);

    @Autowired
    LocalValidatorFactoryBean localValidatorFactoryBean;

    /**
     * 验证用户的验证码
     * @return
     */
    @Bean
    @Order(2)
    public UserLoginFilter verifyCodeFilter(){
        return (t, h) -> {
            if(!t.getCode().equals("111111")){
                LoginException.instance(Resp.error(VERIFY_CODE_ERROR, h).getMessage()).doThrow();
            }

        };
    }

    @Bean
    @Order(1)
    public UserLoginFilter simpleVerifyFilter(){
        return (t, h) -> {
            localValidatorFactoryBean.getValidator()
                    .validate(t)
                    .stream()
                    .findFirst()
                    .ifPresent(a -> LoginException.instance(a.getMessage()).doThrow());
        };
    }

    @Bean
    @Order(0)
    public UserLoginFilter nullCheck(){
        return (t, h) -> {
            Optional.ofNullable(t)
                    .orElseThrow(() -> LoginException.instance(Resp.error(LOGIN_INFO_NULL, h).getMessage()));
        };
    }


}

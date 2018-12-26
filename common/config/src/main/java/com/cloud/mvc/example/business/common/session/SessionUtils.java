package com.cloud.mvc.example.business.common.session;

import com.cloud.mvc.example.business.common.config.message.Resp;
import com.cloud.mvc.example.business.common.config.security.beans.UserAccountDetail;
import com.cloud.mvc.example.business.domain.exceptions.user.LoginException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static com.cloud.mvc.example.business.common.config.message.CommonCodeAndMessage.NOT_LOGIN;

public class SessionUtils {

    public static Long getCurrentUserId() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(t -> t.getAuthentication())
                .map(t -> (UserAccountDetail)t.getPrincipal())
                .map(t -> t.getId())
                .orElseThrow(() -> LoginException.instance(Resp.error(NOT_LOGIN).getMessage()));

    }


}

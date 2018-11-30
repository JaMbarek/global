package com.cloud.mvc.example.business.common.interceptor;

import com.cloud.mvc.example.business.common.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class PagingInterceptor extends AbstractInterceptor implements PageConstants {

    @Override
    String path() {
        return "/**";
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer currPage = Optional.ofNullable(request.getHeader(page))
                .map(t -> Integer.parseInt(t))
                .orElse(defaultPage);

        Integer size = Optional.ofNullable(request.getHeader(limit))
                .map(t -> Integer.parseInt(t))
                .orElse(defaultLimit);

        request.setAttribute(page, currPage);
        request.setAttribute(limit, size);
        return true;
    }
}

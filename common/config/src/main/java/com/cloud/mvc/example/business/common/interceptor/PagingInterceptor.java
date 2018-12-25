package com.cloud.mvc.example.business.common.interceptor;

import com.cloud.mvc.example.business.domain.constants.PageConstants;
import com.cloud.mvc.example.business.common.request.PageHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class PagingInterceptor extends AbstractInterceptor implements PageConstants {

    @Autowired
    PageHolder holder;

    @Override
    public String path() {
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

        holder.setPage(currPage);
        holder.setLimit(size);

        return true;
    }
}

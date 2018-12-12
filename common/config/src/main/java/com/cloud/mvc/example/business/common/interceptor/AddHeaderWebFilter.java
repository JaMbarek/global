package com.cloud.mvc.example.business.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 添加header过滤器
 */
public class AddHeaderWebFilter extends UriWebFilter{

    @Override
    Mono<Void> interceptor(ServerWebExchange exchange, WebFilterChain chain) {
        exchange.getRequest().getHeaders().add("token", "101010");
        return chain.filter(exchange);
    }

    @Override
    protected String url() {
        return "/dict";
    }
}

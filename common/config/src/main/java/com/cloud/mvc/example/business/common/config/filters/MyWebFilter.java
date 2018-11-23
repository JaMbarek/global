package com.cloud.mvc.example.business.common.config.filters;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class MyWebFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String page = exchange.getRequest().getHeaders().getFirst("page");
        String limit = exchange.getRequest().getHeaders().getFirst("page");
        return null;
    }
}

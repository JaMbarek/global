package com.cloud.mvc.example.business.common.interceptor;

import com.google.common.base.Strings;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public abstract class UriWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        boolean b = Strings.isNullOrEmpty(url());
        boolean a  = exchange.getRequest().getURI().getPath().startsWith(url());
        if(!b && a){
            return interceptor(exchange, chain);
        }else{
            return chain.filter(exchange);
        }
    }

    abstract Mono<Void> interceptor(ServerWebExchange exchange, WebFilterChain chain);

    protected String url() {
        return "";
    }


}

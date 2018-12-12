package com.cloud.mvc.example.basic.gateway.retry;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.RetryGatewayFilterFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.retry.Repeat;
import reactor.retry.RepeatContext;
import reactor.retry.Retry;
import reactor.retry.RetryContext;

import java.util.function.Predicate;

@Component
public class CustomRetryGatewayFilterFactory extends RetryGatewayFilterFactory {


    private static final String retry_key = "retry_iteration";

    @Override
    public GatewayFilter apply(RetryConfig retryConfig) {
        retryConfig.validate();

        Predicate<? super RepeatContext<ServerWebExchange>> predicate = context -> {
            ServerWebExchange exchange = context.applicationContext();
            if (exceedsMaxIterations(exchange, retryConfig)) {
                return false;
            }

            exchange.getAttributes().put(retry_key, exchange.getAttributeOrDefault(retry_key, -1) + 1);

            HttpStatus statusCode = exchange.getResponse().getStatusCode();
            HttpMethod httpMethod = exchange.getRequest().getMethod();

            boolean retryableStatusCode = retryConfig.getStatuses().contains(statusCode);

            if (!retryableStatusCode && statusCode != null) { // null status code might mean a network exception?
                // try the series
                retryableStatusCode = retryConfig.getSeries().stream()
                        .anyMatch(series -> statusCode.series().equals(series));
            }

            boolean retryableMethod = retryConfig.getMethods().contains(httpMethod);
            return retryableMethod && retryableStatusCode;
        };

        Repeat<ServerWebExchange> repeat = Repeat.onlyIf(predicate)
                .doOnRepeat(context -> reset(context.applicationContext()));

        Predicate<RetryContext<ServerWebExchange>> retryContextPredicate = context -> {
            if (exceedsMaxIterations(context.applicationContext(), retryConfig)) {
                return false;
            }

            for (Class<? extends Throwable> clazz : retryConfig.getExceptions()) {
                if (clazz.isInstance(context.exception())) {
                    return true;
                }
            }
            return false;
        };



        Retry<ServerWebExchange> reactorRetry = Retry.onlyIf(retryContextPredicate)
                .doOnRetry(context -> reset(context.applicationContext()))
                .retryMax(retryConfig.getRetries());
        return apply(repeat, reactorRetry);
    }
}

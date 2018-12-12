package com.cloud.mvc.example.basic.gateway;

import org.junit.Test;
import reactor.retry.Retry;

public class TestRetry {
    @Test
    public void testRetry(){
        Retry.onlyIf(t -> {
            System.out.println("t:" + t.iteration());
            return true;
        })
                .doOnRetry(t -> {
                    System.out.println("doOnRetry");
                })
                .retryMax(3);
    }
}

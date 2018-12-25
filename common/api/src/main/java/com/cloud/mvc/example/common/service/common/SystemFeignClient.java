package com.cloud.mvc.example.common.service.common;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ConditionOnNotApp("system")
@FeignClient
public @interface SystemFeignClient {


    @AliasFor(annotation = FeignClient.class, attribute = "value")
    String name() default "system";

    @AliasFor(annotation = ConditionOnNotApp.class, attribute = "value")
    String serviceName() default "system";

    @AliasFor(annotation = FeignClient.class, attribute = "url")
    String url() default "";

    /*
     * Whether 404s should be decoded instead of throwing FeignExceptions
	 */
    @AliasFor(annotation = FeignClient.class, attribute = "decode404")
    boolean decode404() default false;

    /**
     * A custom <code>@Configuration</code> for the feign client. Can contain override
     * <code>@Bean</code> definition for the pieces that make up the client, for instance
     * {@link feign.codec.Decoder}, {@link feign.codec.Encoder}, {@link feign.Contract}.
     *
     * @see FeignClientsConfiguration for the defaults
     */
    @AliasFor(annotation = FeignClient.class, attribute = "configuration")
    Class<?>[] configuration() default {};

    /**
     * Fallback class for the specified Feign client interface. The fallback class must
     * implement the interface annotated by this annotation and be a valid spring bean.
     */
    @AliasFor(annotation = FeignClient.class, attribute = "fallback")
    Class<?> fallback() default void.class;

    /**
     * Define a fallback factory for the specified Feign client interface. The fallback
     * factory must produce instances of fallback classes that implement the interface
     * annotated by {@link FeignClient}. The fallback factory must be a valid spring
     * bean.
     *
     * @see feign.hystrix.FallbackFactory for details.
     */
    @AliasFor(annotation = FeignClient.class, attribute = "fallbackFactory")
    Class<?> fallbackFactory() default void.class;

    /**
     * Path prefix to be used by all method-level mappings. Can be used with or without
     * <code>@RibbonClient</code>.
     */
    @AliasFor(annotation = FeignClient.class, attribute = "path")
    String path() default "";

    /**
     * Whether to mark the feign proxy as a primary bean. Defaults to true.
     */
    @AliasFor(annotation = FeignClient.class, attribute = "primary")
    boolean primary() default true;



}

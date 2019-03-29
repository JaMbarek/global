package com.cloud.mvc.example.business.common.config.cache;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@SuppressWarnings("all")
public class ReactiveRedisConfiguration {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    @Primary
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setPort(redisProperties.getPort());
        configuration.setHostName(redisProperties.getHost());
        configuration.setPassword(RedisPassword.of(redisProperties.getPassword()));
        ReactiveRedisConnectionFactory factory = new LettuceConnectionFactory(configuration);
        return factory;
    }

    @Bean
    @Primary
    public ReactiveRedisTemplate reactiveRedisTemplate(ReactiveRedisConnectionFactory factory){

        ReactiveRedisTemplate template = new ReactiveRedisTemplate(factory,
                RedisSerializationContext.newSerializationContext()
                    .hashKey(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                    .hashValue(RedisSerializationContext.SerializationPair.fromSerializer(new GenericFastJsonRedisSerializer()))
                    .key((RedisSerializer)new StringRedisSerializer())
                    .value(new GenericFastJsonRedisSerializer())
                    .build()
                );

        return template;
    }

    @Bean
    public ReactiveValueOperations reactiveValueOperations(ReactiveRedisTemplate template){
        return template.opsForValue();
    }

    @Bean
    public ReactiveListOperations reactiveListOperations(ReactiveRedisTemplate template){
        return template.opsForList();
    }

    @Bean
    public ReactiveZSetOperations reactiveZSetOperations(ReactiveRedisTemplate template){
        return template.opsForZSet();
    }

    @Bean
    public ReactiveHashOperations reactiveHashOperations(ReactiveRedisTemplate template){
        return template.opsForHash();
    }

    @Bean
    public GenericObjectPoolConfig genericObjectPoolConfig() {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        genericObjectPoolConfig.setMinIdle(redisProperties.getMinIdle());
        genericObjectPoolConfig.setMaxTotal(redisProperties.getMaxActive());
        genericObjectPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        return genericObjectPoolConfig;
    }

    public static void main(String[] args) {







    }

}

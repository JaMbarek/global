package com.cloud.mvc.example.data.rest.rest.core;


import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter mjmc = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        DeserializationConfig dc = objectMapper.getDeserializationConfig();
        // 设置反序列化日期格式、忽略不存在get、set的属性
        objectMapper.setConfig(dc.with(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES));
        mjmc.setObjectMapper(objectMapper);


        // 设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        mjmc.setSupportedMediaTypes(list);
        converters.add(mjmc);
    }
}

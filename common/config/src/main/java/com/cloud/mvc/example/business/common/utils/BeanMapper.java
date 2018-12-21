package com.cloud.mvc.example.business.common.utils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

public class BeanMapper {

    private static final MapperFacade INSTANCE = new DefaultMapperFactory.Builder()
            .build().getMapperFacade();

    public static <T> T map(Object source, Class<T> clazz){
        return INSTANCE.map(source, clazz);
    }

    public static <E> List<E> mapList(List objects, Class<E> clazz){
        return INSTANCE.mapAsList(objects, clazz);
    }



}

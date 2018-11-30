package com.cloud.mvc.example.utils.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

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

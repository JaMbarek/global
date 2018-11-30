package com.cloud.mvc.example.utils.mapper;

import lombok.Data;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class MapperTest {

    @Data
    static class A {
        private Integer id;
        private String name1;

    }

    @Data
    static class B {
        private Integer id;
        private String name;
    }


    public static void main(String[] args) {

        A a = new A();
        a.id = 1;a.name1 = "lxl";

        DefaultMapperFactory build = new DefaultMapperFactory.Builder().build();

        build.classMap(A.class, B.class)
                .field("name1", "name")
                .byDefault()
                .register();

        MapperFacade mapperFacade = build.getMapperFacade();
        B map = mapperFacade.map(a, B.class);
        System.out.println(map);


    }



}

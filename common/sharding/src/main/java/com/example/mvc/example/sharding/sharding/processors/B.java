package com.example.mvc.example.sharding.sharding.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {


    @Autowired
    C c;

//    @Autowired
//    public B(C c) {
//        this.c = c;
//    }
}

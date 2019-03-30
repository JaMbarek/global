package com.example.mvc.example.sharding.sharding.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class A {

    @Autowired
    B b;

//    @Autowired
//    public A(B b) {
//        this.b = b;
//    }


    public static void main(String[] args) {

        HashMap<String , String> map = new HashMap<>();
        map.put("a", "b");
        map.get("a");

        ConcurrentHashMap map1 = new ConcurrentHashMap();
        map1.put("a", "b");
        map1.get("a");
        map1.mappingCount();
        map1.size();
    }


}

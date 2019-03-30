package com.example.mvc.example.sharding.sharding.leecode;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {


    public static void main(String[] args) {

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext();
        context.setConfigLocation("classpath:application.xml");
        context.start();


    }



}

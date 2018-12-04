package com.cloud.mvc.example.business.system;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {


    public static void main(String[] args) throws  Exception {


        List<String> list = Files.readAllLines(Paths.get("E:\\github\\global\\business\\system\\src\\test\\java\\com\\cloud\\mvc\\example\\business\\system\\aaa.txt"));
        List<String> list1 = Files.readAllLines(Paths.get("E:\\github\\global\\business\\system\\src\\test\\java\\com\\cloud\\mvc\\example\\business\\system\\bbb.txt"));

        String sql = list.stream().map(a -> {
            String number = a.substring(a.indexOf("=") + 1, a.indexOf(","));
//            System.out.println(number);
            return number;
        }).filter(t -> {
            return !list1.contains(t);
        })
                .collect(Collectors.joining(","));

        System.out.println(sql);
    }

}

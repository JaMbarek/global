package com.cloud.mvc.example.business.system;

import com.google.gson.Gson;
import okhttp3.*;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Sender {



    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {

        IntStream.rangeClosed(1, 10000)
                .forEach(t -> {
                    try {
                        send();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });


    }

    private static void send() throws Exception {

        Bean bean = new Bean();
        bean.setDealPassword("a123456");
        bean.setEntrustPrice(new BigDecimal(ThreadLocalRandom.current().nextInt(1, 21)));
        bean.setEntrustCount(new BigDecimal("0.01"));
        bean.setMarketId(26);
        bean.setType(2);
        bean.setEntrustType(0);


        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new Gson().toJson(bean));
        Request request = new Request.Builder()
                .url("http://192.168.1.230:9021/transaction/api/v1/user/entrust")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("accessToken", "3c9dc115-ab8b-46a9-aac8-2dce5b672189")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "9dea9578-cb58-4fa0-9bcb-9f8e06f2ff27")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }


}

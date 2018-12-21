package com.cloud.mvc.example.business.system;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import okhttp3.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Sender {



    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {
        final CountDownLatch latch = new CountDownLatch(3);

        System.out.println("0." + RandomStringUtils.randomNumeric(2));

        new Thread(() -> {
            IntStream.rangeClosed(1, 4000)
                    .forEach(t -> {
                        try {
//                            send(t, 1, new BigDecimal(8));
//                            send(t, 1, new BigDecimal(9));
//                            send(t, 1, new BigDecimal(7));
//                            send(t, 1, new BigDecimal(6));
//                            send(t, 1, new BigDecimal(5));
//                            send(t, 1, new BigDecimal(4));
//                            send(t, 1, new BigDecimal(3));
                            send(t, 1, new BigDecimal(2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            latch.countDown();
        }).start();

        new Thread(() -> {
            IntStream.rangeClosed(1, 4000)
                    .forEach(t -> {
                        try {
                            send(t, 2, new BigDecimal(1));
//                            send(t, 2, new BigDecimal("0.9"));
//                            send(t, 2, new BigDecimal("0.8"));
//                            send(t, 2, new BigDecimal("0.7"));
//                            send(t, 2, new BigDecimal("0.6"));
//                            send(t, 2, new BigDecimal("0.5"));
//                            send(t, 2, new BigDecimal("0.4"));
//                            send(t, 2, new BigDecimal("0.3"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            latch.countDown();
        }).start();
        latch.await();

    }


    @Test
    public void testRetry(){

    }


    private static void send(int t, int type, BigDecimal price) throws Exception {

        Bean bean = new Bean();
        bean.setDealPassword("dc483e80a7a0bd9ef71d8cf973673924");
        bean.setEntrustPrice(price);
        bean.setEntrustCount(new BigDecimal("0." + RandomStringUtils.randomNumeric(4)));
        bean.setMarketId(59);
        bean.setType(type);
        bean.setEntrustType(0);
        // test:  a2007b49-cdc9-427b-a4d3-46d8ea100e24
        // dev:   90e6424f-36a4-4312-902f-11fd2a47ef5d

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new Gson().toJson(bean));
        Request request = new Request.Builder()
                .url("http://192.168.1.230:9021/transaction/api/v1/user/entrust")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("accessToken", "a2007b49-cdc9-427b-a4d3-46d8ea100e24")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "9dea9578-cb58-4fa0-9bcb-9f8e06f2ff27")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string() + ",count=" + t);
    }


}

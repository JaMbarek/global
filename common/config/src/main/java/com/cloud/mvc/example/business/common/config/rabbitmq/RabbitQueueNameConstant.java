package com.cloud.mvc.example.business.common.config.rabbitmq;


/**
 * Rabbit 队列名称常量类，需要添加一个队列只需要增加常量即可
 */
public class RabbitQueueNameConstant {

    public static final String ZIPKIN = "zipkin";

    //死信队列声明
    public static final String DEAD_LETTER = "GlobalDeadLetter";


}

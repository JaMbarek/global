package com.cloud.mvc.example.business.common.config.rabbitmq;


import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitQueueCreater {

    static RabbitTemplate rabbitTemplate;
    static RabbitAdmin rabbitAdmin;

    @Autowired
    public RabbitQueueCreater(RabbitTemplate rabbitTemplate, RabbitAdmin rabbitAdmin) {
        RabbitQueueCreater.rabbitTemplate = rabbitTemplate;
        RabbitQueueCreater.rabbitAdmin = rabbitAdmin;
    }

    public static boolean createQueue(String queueName){
        rabbitAdmin.declareQueue(QueueBuilder.durable(queueName).build());
        return true;
    }


}

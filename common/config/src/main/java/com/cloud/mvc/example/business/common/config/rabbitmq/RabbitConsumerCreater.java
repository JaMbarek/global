package com.cloud.mvc.example.business.common.config.rabbitmq;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class RabbitConsumerCreater {


    static RabbitTemplate rabbitTemplate;
    static RabbitAdmin rabbitAdmin;

    @Autowired
    public RabbitConsumerCreater(RabbitTemplate rabbitTemplate, RabbitAdmin rabbitAdmin) {
        RabbitConsumerCreater.rabbitTemplate = rabbitTemplate;
        RabbitConsumerCreater.rabbitAdmin = rabbitAdmin;
    }

    public static <A> void createComsumer(String queueName, Consumer<A> consumer){

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(rabbitTemplate.getConnectionFactory());

        MessageListener listener = message -> {
            Object obj = new Jackson2JsonMessageConverter().fromMessage(message);
            consumer.accept((A) obj);
        };

        container.setMessageListener(listener);
        container.setQueueNames(queueName);
        container.start();
    }




}

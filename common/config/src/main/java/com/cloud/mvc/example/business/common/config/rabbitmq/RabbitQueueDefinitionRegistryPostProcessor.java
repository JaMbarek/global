package com.cloud.mvc.example.business.common.config.rabbitmq;

import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.lang.reflect.Field;

import static com.cloud.mvc.example.business.common.config.rabbitmq.RabbitQueueNameConstant.DEAD_LETTER;
import static com.cloud.mvc.example.business.common.config.rabbitmq.RabbitQueueNameConstant.ZIPKIN;


/**
 * 自动实例化Rabiit队列并提交给Spring管理处理器
 */
@Configuration
public class RabbitQueueDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Environment environment;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        logger.info("Invoke Rabiit Queue  postProcessBeanDefinitionRegistry");

        RabbitQueueNameConstant queueNameConstant = new RabbitQueueNameConstant();

        final Field[] fields = queueNameConstant.getClass().getFields();

        for (Field field : fields
                ) {
            try {
                String queueName = (String) field.get(queueNameConstant);
                registerBean(registry, queueName, Queue.class);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("Invoke Rabiit Queue postProcessBeanFactory");
    }

    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(beanClass);
        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
        argumentValues.addIndexedArgumentValue(0, name);
        if(!name.equals(DEAD_LETTER) && !name.equals(ZIPKIN)){
            String exchange = environment.resolvePlaceholders("${spring.rabbitmq.direct.exchange}");
            argumentValues.addIndexedArgumentValue(1, true);//durable
            argumentValues.addIndexedArgumentValue(2, false);//exclusive
            argumentValues.addIndexedArgumentValue(3, false);//autoDelete
            argumentValues.addIndexedArgumentValue(4, ImmutableMap.of(//arguements
                    "x-dead-letter-exchange", exchange,
                    "x-dead-letter-routing-key", DEAD_LETTER
            ));
            bdb.getBeanDefinition().setConstructorArgumentValues(argumentValues);

            BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(bdb.getBeanDefinition(), name);
            BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
        }
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}



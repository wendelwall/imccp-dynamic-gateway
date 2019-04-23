package com.inphase.imccp.domain.config;

import com.rabbitmq.client.impl.Environment;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:xianxiong
 * @Date: Create in 14:07 2019/1/2 0002
 */
//@Configuration
@EnableCaching
public class RabbitConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    /**
     * 单一消费者
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

    @Bean
    public DirectExchange basicExchange(){
        return new DirectExchange("route.exchange", true,false);
    }

    @Bean(name = "basicQueue")
    public Queue basicQueue(){
        return new Queue("route.queue", true);
    }

    @Bean
    public Binding basicBinding(){
        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with("route.key");
    }


    /**
     * 定义一个hello的队列
     * Queue 可以有4个参数
     *      1.队列名
     *      2.durable       持久化消息队列 ,rabbitmq重启的时候不需要创建新的队列 默认true
     *      3.auto-delete   表示消息队列没有在使用时将被自动删除 默认是false
     *      4.exclusive     表示该消息队列是否只在当前connection生效,默认是false
     */
//    @Bean(name = "helloQueue")
//    public Queue helloQueue() {
//        return new Queue("queue-test");
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(new Jackson2JsonMessageConverter());
//        return template;
//    }
//
}

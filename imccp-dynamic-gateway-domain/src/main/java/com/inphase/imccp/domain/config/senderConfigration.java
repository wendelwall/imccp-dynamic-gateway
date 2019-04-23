package com.inphase.imccp.domain.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:xianxiong
 * @Date: Create in 15:28 2019/3/29 0029
 */
@Configuration
public class senderConfigration {
    /**
     *@Description: 新建队列 topic.messages
     */
    @Bean(name = "messages")
    public Queue queueMessages(){
        return new Queue("topic.messages");
    }

    @Bean(name = "send")
    public Queue queueAllRoute(){
        return new Queue("topic.send");
    }

    @Bean(name = "update")
    public Queue queueAddRoute(){
        return new Queue("topic.update");
    }

    /**
     *@Description: 定义交换器
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }
    /**
     *@Description: 交换机与消息队列进行绑定 队列messages绑定交换机with topic.messages
     */
    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.messages");
    }

    @Bean
    Binding bindingExchangeAllroute(@Qualifier("send") Queue queueAllRoute, TopicExchange exchange){
        return BindingBuilder.bind(queueAllRoute).to(exchange).with("topic.send");
    }

    @Bean
    Binding bindingExchangeAddroute(@Qualifier("update") Queue queueAddRoute, TopicExchange exchange){
        return BindingBuilder.bind(queueAddRoute).to(exchange).with("topic.update");
    }
}

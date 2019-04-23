//package com.inphase.imccp.domain.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.AllArgsConstructor;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @Author:xianxiong
// * @Date: Create in 20:45 2019/1/1 0001
// * @EnableCaching：必须加，使配置生效
// */
//@EnableCaching
//@Configuration
//@ConditionalOnBean(RedisConnectionFactory.class)
//@AllArgsConstructor
//public class RedisConfiguration {
//
//    private final RedisConnectionFactory redisConnectionFactory;
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return redisTemplate;
//    }
//
//}

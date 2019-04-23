package com.inphase.imccp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:xianxiong
 * @Date: Create in 15:17 2019/3/28 0028
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.inphase.imccp.client.client")
@EnableHystrix
@ComponentScan(basePackages={"com.inphase.imccp.web","com.inphase.imccp.client"})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}

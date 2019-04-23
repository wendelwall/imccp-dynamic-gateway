package com.inphase.imccp.restapi;

import com.inphase.imccp.domain.service.SysRouteConfService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * @Author:xianxiong
 * @Date: Create in 18:10 2018/12/25 0025
 */
@SpringBootApplication
@MapperScan("com.inphase.imccp.domain.dao")
@EnableSwagger2
@ComponentScan(basePackages = {"com.inphase.imccp.restapi","com.inphase.imccp.domain"})
public class DynamicGatewayResapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicGatewayResapiApplication.class,args);
    }

}

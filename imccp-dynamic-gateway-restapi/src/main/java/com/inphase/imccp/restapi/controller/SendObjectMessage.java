package com.inphase.imccp.restapi.controller;

import com.inphase.imccp.domain.service.SysRouteConfService;
import com.inphase.imccp.object.returnobject.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:xianxiong
 * @Date: Create in 10:39 2019/1/4 0004
 */
@RestController
@RequestMapping(value = "/apply")
@Api(description="应用修改")
public class SendObjectMessage {

    private static final Logger log= LoggerFactory.getLogger(SendObjectMessage.class);

    @Resource
    private SysRouteConfService sysRouteConfService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    private String ROUTE_KEY = "gateway_route_key";

    @RequestMapping(value = "/sendStr", method = RequestMethod.GET)
    @ApiOperation(value = "测试发送消息",response = JsonResult.class)
    public void send(){
        amqpTemplate.convertAndSend("exchange","topic.messages","hello topic.messages RabbitMQ");
    }

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    @ApiOperation(value = "应用修改",response = JsonResult.class)
    public JsonResult sendEntity(){
        return sysRouteConfService.apply();
    }


}

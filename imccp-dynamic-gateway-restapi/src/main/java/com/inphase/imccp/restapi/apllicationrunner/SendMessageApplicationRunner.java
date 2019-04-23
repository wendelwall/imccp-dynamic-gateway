package com.inphase.imccp.restapi.apllicationrunner;

import com.inphase.imccp.domain.service.SysRouteConfService;
import com.inphase.imccp.object.returnobject.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author:xianxiong
 * @Date: Create in 14:52 2019/3/30 0030
 *
 *  配置服务启动时,获取所有数据库路由信息,加载到redis中，并发送消息到队列，通知gateway-server启动时，来消费此队列消息。进行路由配置。
 */
@Component
@Order(value = 1)
public class SendMessageApplicationRunner implements ApplicationRunner {

    private Logger log = LoggerFactory.getLogger(SendMessageApplicationRunner.class);

    @Resource
    private SysRouteConfService sysRouteConfService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JsonResult jsonResult = sysRouteConfService.getAll();
        if (jsonResult.getCode().equals(200)){
            log.info("初始化路由成功！！！");
        }else {
            log.error("初始化路由失败！！");
        }
    }
}

package com.inphase.imccp.web.controller;

import com.inphase.imccp.client.client.ApplyClient;
import com.inphase.imccp.object.returnobject.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xianxiong
 * @Date: Create in 20:37 2019/3/31 0031
 */
@RestController
@RequestMapping(value = "/apply")
@Api(description = "应用配置接口")
public class ApplyController {

    private ApplyClient applyClient;

    public ApplyController(ApplyClient applyClient){
        this.applyClient = applyClient;
    }

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    @ApiOperation(value = "应用修改",response = JsonResult.class)
    public JsonResult sendEntity(){
        return applyClient.apply();
    }
}

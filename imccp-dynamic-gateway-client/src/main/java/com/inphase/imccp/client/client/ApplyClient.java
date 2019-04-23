package com.inphase.imccp.client.client;

import com.inphase.imccp.client.hytrix.ApplyHytrix;
import com.inphase.imccp.object.returnobject.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author:xianxiong
 * @Date: Create in 20:39 2019/3/31 0031
 */
@FeignClient(value = "imccp-dynamic-gateway-restapi",fallback = ApplyHytrix.class)
public interface ApplyClient {

    @RequestMapping(value = "/apply/send",method = RequestMethod.GET)
    public JsonResult apply();
}

package com.inphase.imccp.client.client;

import com.inphase.imccp.client.hytrix.SysRouteConfHytrix;
import com.inphase.imccp.object.returnobject.JsonResult;
import com.inphase.imccp.object.returnobject.gitListResult;
import com.inphase.imccp.object.vo.SysRouteConfVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:xianxiong
 * @Date: Create in 15:54 2019/3/28 0028
 */
@FeignClient(value = "imccp-dynamic-gateway-restapi",fallback = SysRouteConfHytrix.class)
public interface SysRouteConfClient {

    @RequestMapping(value = "/route/getList",method = RequestMethod.GET)
    gitListResult findForPage(@RequestParam(value = "pageNum")Integer pageNum, @RequestParam(value = "pageSize")Integer pageSize);

    @RequestMapping(value = "/route/add",method = RequestMethod.POST)
    JsonResult add(@Validated @RequestBody SysRouteConfVo sysRouteConfVo);

    @RequestMapping(value = "/route/deleteById",method = RequestMethod.GET)
    JsonResult deleteById(@RequestParam(value = "id")String id);

    @RequestMapping(value = "/route/update",method = RequestMethod.POST)
    JsonResult update(@Validated @RequestBody SysRouteConfVo sysRouteConfVo);
}

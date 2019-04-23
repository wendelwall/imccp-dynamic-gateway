package com.inphase.imccp.restapi.controller;

import com.inphase.imccp.object.returnobject.JsonResult;
import com.inphase.imccp.domain.service.SysRouteConfService;
import com.inphase.imccp.object.returnobject.gitListResult;
import com.inphase.imccp.object.vo.SysRouteConfVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author:xianxiong
 * @Date: Create in 21:48 2018/12/25 0025
 */

@RestController
@RequestMapping(value = "/route")
@Api(description = "动态路由配置接口")
public class SysRouteConfController {

    @Resource
    private SysRouteConfService sysRouteConfService;

    @GetMapping(value = "/getList")
    @ApiOperation(value = "获取所有列表",response = JsonResult.class)
    public gitListResult getList(@RequestParam(value = "pageNum")Integer pageNum, @RequestParam(value = "pageSize")Integer pageSize){
        return sysRouteConfService.getList(pageNum,pageSize);
    }

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加路由",response = JsonResult.class)
    public JsonResult add(@Validated @RequestBody SysRouteConfVo sysRouteConfVo){
        return sysRouteConfService.add(sysRouteConfVo);
    }

    @GetMapping(value = "/deleteById")
    @ApiOperation(value = "根据id删除路由",response = JsonResult.class)
    public JsonResult deleteById(@RequestParam String id){
        return sysRouteConfService.deleteById(id);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改路由信息",response = JsonResult.class)
    public JsonResult update(@Validated @RequestBody SysRouteConfVo sysRouteConfVo){
        return sysRouteConfService.update(sysRouteConfVo);
    }








}

package com.inphase.imccp.web.controller;

import com.inphase.imccp.client.client.SysRouteConfClient;
import com.inphase.imccp.object.returnobject.JsonResult;
import com.inphase.imccp.object.returnobject.gitListResult;
import com.inphase.imccp.object.vo.SysRouteConfVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:xianxiong
 * @Date: Create in 15:27 2019/3/28 0028
 */
@RestController
@RequestMapping(value = "/route")
@Api(description = "动态路由配置相关接口")
public class DynamicController {

    private SysRouteConfClient sysRouteConfClient;

    public DynamicController(SysRouteConfClient sysRouteConfClient){
        this.sysRouteConfClient = sysRouteConfClient;
    }

    @GetMapping(value = "/findForPage")
    @ApiOperation(value = "分页查询所有路由信息",response = SysRouteConfVo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页码",required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "条数",required = true,defaultValue = "10")
    })
    public gitListResult findForPage(@RequestParam(value = "pageNum")Integer pageNum, @RequestParam(value = "pageSize")Integer pageSize){
        return sysRouteConfClient.findForPage(pageNum,pageSize);
    }

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加路由",response = JsonResult.class)
    public JsonResult add(@Validated @RequestBody SysRouteConfVo sysRouteConfVo){
        return sysRouteConfClient.add(sysRouteConfVo);
    }

    @GetMapping(value = "/deleteById")
    @ApiOperation(value = "根据id删除路由",response = JsonResult.class)
    public JsonResult deleteById(@RequestParam String id){
        return sysRouteConfClient.deleteById(id);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改路由信息",response = JsonResult.class)
    public JsonResult update(@Validated @RequestBody SysRouteConfVo sysRouteConfVo){
        return sysRouteConfClient.update(sysRouteConfVo);
    }
}

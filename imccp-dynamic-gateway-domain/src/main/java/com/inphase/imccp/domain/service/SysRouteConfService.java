package com.inphase.imccp.domain.service;

import com.inphase.imccp.object.returnobject.JsonResult;
import com.inphase.imccp.object.returnobject.gitListResult;
import com.inphase.imccp.object.vo.SysRouteConfVo;

import java.util.List;

/**
 * @Author:xianxiong
 * @Date: Create in 21:46 2018/12/25 0025
 */
public interface SysRouteConfService {

    gitListResult getList(Integer pageNum, Integer pageSize);

    JsonResult add(SysRouteConfVo sysRouteConfVo);

    JsonResult deleteById(String id);

    JsonResult update(SysRouteConfVo sysRouteConfVo);

    JsonResult apply();

    JsonResult getAll();
}

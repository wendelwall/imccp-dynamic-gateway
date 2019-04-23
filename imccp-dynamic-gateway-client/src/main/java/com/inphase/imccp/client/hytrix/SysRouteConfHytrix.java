package com.inphase.imccp.client.hytrix;

import com.inphase.imccp.client.client.SysRouteConfClient;
import com.inphase.imccp.object.constant.ResultCode;
import com.inphase.imccp.object.returnobject.JsonResult;
import com.inphase.imccp.object.returnobject.gitListResult;
import com.inphase.imccp.object.vo.SysRouteConfVo;
import org.springframework.stereotype.Component;

/**
 * @Author:xianxiong
 * @Date: Create in 15:57 2019/3/28 0028
 */
@Component
public class SysRouteConfHytrix implements SysRouteConfClient {

    @Override
    public gitListResult findForPage(Integer pageNum, Integer pageSize) {
        gitListResult jsonResult = new gitListResult();
        jsonResult.setCode(ResultCode.REQUEST_TIMEOUT.code());
        jsonResult.setMessage(ResultCode.REQUEST_TIMEOUT.message());
        return jsonResult;
    }

    @Override
    public JsonResult add(SysRouteConfVo sysRouteConfVo) {
        return new JsonResult(ResultCode.REQUEST_TIMEOUT.code(),ResultCode.REQUEST_TIMEOUT.message());
    }

    @Override
    public JsonResult deleteById(String id) {
        return new JsonResult(ResultCode.REQUEST_TIMEOUT.code(),ResultCode.REQUEST_TIMEOUT.message());
    }

    @Override
    public JsonResult update(SysRouteConfVo sysRouteConfVo) {
        return new JsonResult(ResultCode.REQUEST_TIMEOUT.code(),ResultCode.REQUEST_TIMEOUT.message());
    }
}

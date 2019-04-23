package com.inphase.imccp.client.hytrix;

import com.inphase.imccp.client.client.ApplyClient;
import com.inphase.imccp.object.constant.ResultCode;
import com.inphase.imccp.object.returnobject.JsonResult;
import org.springframework.stereotype.Component;

/**
 * @Author:xianxiong
 * @Date: Create in 20:44 2019/3/31 0031
 */
@Component
public class ApplyHytrix implements ApplyClient {
    @Override
    public JsonResult apply() {
        return new JsonResult(ResultCode.REQUEST_TIMEOUT.code(),ResultCode.REQUEST_TIMEOUT.message());
    }
}

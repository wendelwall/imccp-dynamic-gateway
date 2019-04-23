package com.inphase.imccp.domain.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.inphase.imccp.object.dto.TbRouteDto;

/**
 * @Author:xianxiong
 * @Date: Create in 22:37 2019/1/3 0003
 */
public class FastJsonConvertUtil<T> {

    public static String convertObjectToJSON(TbRouteDto tbRouteDto)
    {
        return JSON.toJSONString(tbRouteDto);

    }


    public static TbRouteDto convertJSONToObject(String message, Class<TbRouteDto> class1)
    {
        JSONObject json = JSONObject.parseObject(message);
        return json.toJavaObject(class1);
    }

    public static JSONObject toJsonObject(Object javaBean)
    {
        return JSONObject.parseObject(JSONObject.toJSON(javaBean).toString());
    }
}

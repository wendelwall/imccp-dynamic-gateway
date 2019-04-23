package com.inphase.imccp.object.returnobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:xianxiong
 * @Date: Create in 18:55 2019/3/28 0028
 */

@ApiModel(description = "统一的返回结果")
public class JsonResult<T> {

    @ApiModelProperty("编码")
    private Integer code;

    @ApiModelProperty("消息")
    private String message;

    @ApiModelProperty("数据")
    private T data;

    public JsonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    public JsonResult(){

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

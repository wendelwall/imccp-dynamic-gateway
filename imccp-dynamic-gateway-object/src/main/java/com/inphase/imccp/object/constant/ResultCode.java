package com.inphase.imccp.object.constant;

/**
 * @Author:xianxiong
 * @Date: Create in 15:27 2019/3/28 0028
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200,"操作成功！"),
    UNAUTHORIZED(401,"签名错误"),
    NOT_FOUND(404,"接口不存在"),
    VALUE_NULL(406,"参数为空！"),
    INPUT_QUEUE_FAILD(407,"写入消息进队列失败！"),
    REQUEST_TIMEOUT(408,"请求超时"),
    SERVER_HYTRIC(409,"服务熔断");

    private final int code;
    private final String message;

    ResultCode(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }
    public String message(){
        return message;
    }
}


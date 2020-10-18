package com.zengande.dianping.commom;

public enum ResultStateCode {

    SUCCESS(10000, "成功"),
    REQUEST_OBJECT_NOTFOUND(10001, "请求对象不存在"),
    UNKNOWN_ERROR(10002, "未知错误"),
    NO_HANDLER_FOUND(10003, "找不到执行的路径操作"),
    BIND_EXCEPTION_ERROR(10004, "请求参数错误");


    private Integer code;
    private String message;

    ResultStateCode(Integer code, String message) {
        this.code = code;
        this.message = message;
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
}

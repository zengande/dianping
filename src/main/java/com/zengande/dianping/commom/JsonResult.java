package com.zengande.dianping.commom;

/**
 * 统一返回格式
 */
public class JsonResult {

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Integer code;
    private String message;
    private Object data;

    /**
     * 返回成功结果
     * @param data 数据
     * @return JsonResult 对象
     */
    public static JsonResult success(Object data) {
        ResultStateCode success = ResultStateCode.SUCCESS;
        return create(data, success.getCode(),success.getMessage());
    }

    /**
     * 返回错误结果
     * @param error
     * @return
     */
    public static JsonResult fail(ResultStateCode error){
        return  create(null, error.getCode(), error.getMessage());
    }

    /**
     * 构建 JsonResult 对象
     * @param data 数据
     * @param code 状态码
     * @param message 消息
     * @return
     */
    public static JsonResult create(Object data, Integer code, String message) {
        JsonResult result = new JsonResult();
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);

        return result;
    }
}

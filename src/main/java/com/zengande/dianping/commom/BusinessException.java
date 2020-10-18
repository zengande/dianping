package com.zengande.dianping.commom;

public class BusinessException extends Exception {
    public JsonResult getResult() {
        return result;
    }

    private JsonResult result;

    public BusinessException(JsonResultCode error) {
        super();

        this.result = JsonResult.fail(error);
    }
}

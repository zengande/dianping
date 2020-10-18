package com.zengande.dianping.commom;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handle(HttpServletRequest request, HttpServletResponse response, Exception exception){
        if(exception instanceof BusinessException){
            return  ((BusinessException) exception).getResult();
        }else if(exception instanceof NoHandlerFoundException){ // 404
            return JsonResult.fail(ResultStateCode.NO_HANDLER_FOUND);
        } else if(exception instanceof ServletRequestBindingException){ // 请求参数错误
            return JsonResult.fail(ResultStateCode.BIND_EXCEPTION_ERROR);
        }
        // 未知错误
        return JsonResult.fail(ResultStateCode.UNKNOWN_ERROR);
    }
}

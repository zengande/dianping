package com.zengande.dianping.commom;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handleException(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        if (exception instanceof BusinessException) {
            return ((BusinessException) exception).getResult();
        } else if (exception instanceof NoHandlerFoundException) { // 404
            return JsonResult.fail(JsonResultCode.NO_HANDLER_FOUND);
        } else if (exception instanceof ServletRequestBindingException) { // 请求参数错误
            return JsonResult.fail(JsonResultCode.BIND_EXCEPTION_ERROR);
        } else if (exception instanceof BindException) {
            return handleBindException((BindException) exception);
        } else if(exception instanceof MethodArgumentNotValidException){
            return handleMethodArgumentNotValidException((MethodArgumentNotValidException)exception);
        }
        // 未知错误
        return JsonResult.fail(JsonResultCode.UNKNOWN_ERROR);
    }

    private JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return handleFieldErrors(bindingResult.getFieldErrors());
    }

    private JsonResult handleBindException(BindException exception) {
        return handleFieldErrors(exception.getFieldErrors());
    }

    private JsonResult handleFieldErrors(List<FieldError> errors){
        JsonResultCode stateCode = JsonResultCode.BIND_EXCEPTION_ERROR;

        List<String> messages = errors.stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        String message = String.join(",", messages);

        stateCode.setMessage(message);
        return JsonResult.fail(stateCode);
    }
}

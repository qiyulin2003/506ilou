package com.moehu.back.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionError {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> exceptionHandler (Exception ex) {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code", 500);
        result.put("message",ex.getMessage());
        result.put("data", null);

        System.out.println(ex.getMessage());
        if (ex.getMessage().contains("无效token")) {
            result.put("code", 403);
        }

        return result;
    }
}
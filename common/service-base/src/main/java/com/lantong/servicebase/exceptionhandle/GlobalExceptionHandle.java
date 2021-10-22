package com.lantong.servicebase.exceptionhandle;

import com.lantong.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandle {

    //统一异常处理机制
    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error();
    }

    //自定义异常处理机制
    @ExceptionHandler(CMSException.class)
    @ResponseBody
    public Result error(CMSException e){
        return Result.error().message(e.getMsg()).code(e.getCode());
    }


}

package com.lantong.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //响应信息
    private String message;
    //响应数据
    private Map<String,Object> data = new HashMap<>();

    //构造器私有,不让外界构造
    private  Result (){

    }
    //通用返回成功
    public static Result ok(){
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return result;
    }
    //通用返回失败
    public static Result error(){
        Result result = new Result();
        result.setSuccess(ResultCodeEnum.ERROR.getSuccess());
        result.setCode(ResultCodeEnum.ERROR.getCode());
        result.setMessage(ResultCodeEnum.ERROR.getMessage());
        return result;
    }
    //设置结果,形参为结果枚举
    public static Result setResult(ResultCodeEnum r){
        Result result = new Result();
        result.setSuccess(r.getSuccess());
        result.setCode(r.getCode());
        result.setMessage(r.getMessage());
        return result;
    }

    //返回类本身,链式编程
//-------------------------------------------------------------------------------
    //自定义返回数据
    public Result data (Map<String,Object> map){
        this.setData(map);
        return this;
    }

    //通用返回数据
    public Result data (String key,Object value){
        this.data.put(key,value);
        return this;
    }

    //自定义成功标识
    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    //自定义状态码
    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    //自定义响应消息
    public Result message(String message){
        this.setMessage(message);
        return this;
    }

}

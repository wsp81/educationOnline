package com.lantong.utils;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(true, 20000, "成功"),
    ERROR(false,20001,"失败");

    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //响应信息
    private String message;

    ResultCodeEnum(boolean success,Integer code,String message){
        this.success=success;
        this.code=code;
        this.message=message;
    }

}
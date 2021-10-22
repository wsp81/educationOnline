package com.lantong.servicebase.exceptionhandle;

import com.lantong.utils.ResultCodeEnum;
import lombok.Data;

@Data
public class CMSException extends RuntimeException{
    private Integer code;
    private String msg;

    public CMSException(Integer code,String message){
        this.msg=message;
        this.code=code;
    }

    public CMSException(ResultCodeEnum resultCodeEnum){
        this.msg=resultCodeEnum.getMessage();
        this.code=resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ",message"+msg+"}";
    }
}

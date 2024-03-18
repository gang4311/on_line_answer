package com.tencent.wxcloudrun.common;

public enum ExceptionEnum {
    PARAM_EXCEPTION(400,"参数异常"),
    RUNTIME_EXCEPTION(500,"运行异常"),
    ;



    private Integer code ;

    private String msg ;

    ExceptionEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

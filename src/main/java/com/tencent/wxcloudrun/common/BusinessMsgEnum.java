package com.tencent.wxcloudrun.common;

public enum BusinessMsgEnum {

    ;

    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常提示信息
     */
    private String message;


    BusinessMsgEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }

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
}

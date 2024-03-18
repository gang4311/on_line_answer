package com.tencent.wxcloudrun.common;

import java.util.Objects;

public enum UserTypeEnum {
    ADMIN(1,"admin"),
    NORMAL(0,"normal")
    ;


    private Integer code;

    private String msg;

    UserTypeEnum(Integer code,String msg){
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

    public static String getMsgByCode(Integer code){
        for (UserTypeEnum value : UserTypeEnum.values()) {
            if(Objects.equals(code,value.getCode())){
                return value.getMsg();
            }
        }
        return null;
    }
}

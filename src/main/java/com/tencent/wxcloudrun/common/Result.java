package com.tencent.wxcloudrun.common;

import lombok.Data;


@Data
public class Result<T> {

    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String msg;

    /**
     * 返回结果
     */
    private T data;

    public Result() {
        this.code = 200;
        this.msg = "操作成功";
    }

    public Result(Integer code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data=data;
    }

    public Result(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

    public static Result ok() {
        return new Result(200, "", null);
    }

    public static Result ok(Object data) {
        return new Result(0, "", data);
    }

    public static Result error(String errorMsg) {
        return new Result(500, errorMsg,null);
    }
    public static Result error(Integer code,String errorMsg) {
        return new Result(code, errorMsg,null);
    }

}

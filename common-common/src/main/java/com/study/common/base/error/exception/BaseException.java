package com.study.common.base.error.exception;

public class BaseException  extends  RuntimeException {
    public BaseException() {
        super();
    }

    private  Integer  code ;

    public BaseException( Integer  code  ,String message) {
        super(message);
        this.code  = code;
    }

    public Integer getCode() {
        return code;
    }
}

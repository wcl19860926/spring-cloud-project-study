package com.study.common.core.exception;

import com.study.common.base.error.codes.ErrorCode;
import lombok.Data;

@Data
public class BizException extends RuntimeException {

    private int errorCode;
    private String errorMsg;

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorCode = -1;
        this.errorMsg = errorMsg;
    }
    public BizException(ErrorCode errorMsg) {
        this.errorCode = errorMsg.getCode();

    }

    public BizException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return this.errorMsg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

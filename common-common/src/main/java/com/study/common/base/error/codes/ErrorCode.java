package com.study.common.base.error.codes;

import lombok.Data;

@Data
public class ErrorCode {
    private int code;
    private String msgKey;

    public ErrorCode(int code, String msgKey) {
        this.code = code;
        this.msgKey = msgKey;
    }
}

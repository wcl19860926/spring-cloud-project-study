package com.study.common.base.dto;


import com.study.common.base.error.codes.ErrorCode;
import com.study.common.base.error.exception.BaseException;
import com.study.common.core.exception.BizException;

/**
 * api接口返回的数据格式
 *
 * @param <T>
 */
public class ResultDto<T> {
    private boolean isSuccess;
    private Integer code;
    private T data;
    private String message;

    /**
     * 禁止new，全部使用静态方法
     */
    private ResultDto() {
        this.code = 0;
        this.isSuccess = Boolean.TRUE;
    }

    private ResultDto(T data) {
        this.code = 0;
        this.data = data;
        this.isSuccess = Boolean.TRUE;
    }


    public ResultDto(ErrorCode messageCode) {
        this.code = messageCode.getCode();
        this.isSuccess = Boolean.FALSE;
    }

    public ResultDto(ErrorCode messageCode , String ... args) {
        this.code = messageCode.getCode();
        this.isSuccess = Boolean.FALSE;
    }

    public ResultDto(BizException messageCode) {
        this.code = messageCode.getErrorCode();
        this.isSuccess = Boolean.FALSE;
    }


    public static <T> ResultDto<T> sucess(T data) {
        return new ResultDto<T>(data);
    }

    public static ResultDto fail(Integer code) {
        return new ResultDto<>(code);
    }

    public static ResultDto fail(String errMsg) {
        return null;
    }

    public static <T> ResultDto<T> fail(BaseException ex) {
        return new ResultDto(ex.getCode());
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

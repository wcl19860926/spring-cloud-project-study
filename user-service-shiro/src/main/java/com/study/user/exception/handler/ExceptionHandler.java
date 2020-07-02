package com.study.user.exception.handler;

import com.study.common.base.dto.ResultDto;
import com.study.common.base.error.codes.ErrorCodes;
import com.study.common.exception.GlobalExceptionHandler;
import org.apache.shiro.authz.UnauthorizedException;

public class ExceptionHandler  extends GlobalExceptionHandler {


    /**
     * 权限异常处理
     *
     * @param exception
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = UnauthorizedException.class)
    public ResultDto unauthorizedExceptionHandler(UnauthorizedException exception) {

        return ResultDto.fail(ErrorCodes.SYS_ERROR_403);
    }
}
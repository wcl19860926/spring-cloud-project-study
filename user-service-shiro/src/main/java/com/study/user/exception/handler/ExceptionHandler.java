package com.study.user.exception.handler;

import com.study.common.base.dto.ResultDto;
import com.study.common.base.error.codes.ErrorCodes;
import com.study.common.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
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

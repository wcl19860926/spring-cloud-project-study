package com.study.user.exception.handler;

import com.study.common.base.dto.ResultDto;
import com.study.common.base.error.codes.ErrorCodes;
import com.study.common.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@RestControllerAdvice
public class UserServiceExceptionHandler extends GlobalExceptionHandler {


    /**
     * 权限异常处理
     *
     * @param exception
     * @return
     */

    @ExceptionHandler({UnauthorizedException.class, UnauthenticatedException.class } )
    public ResultDto unauthorizedExceptionHandler(UnauthorizedException exception) {
        log.error("无此权限:{}", exception.getMessage());
        return ResultDto.fail(ErrorCodes.SYS_ERROR_403);
    }



}

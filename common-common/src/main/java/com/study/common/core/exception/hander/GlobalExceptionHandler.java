package com.study.common.core.exception.hander;

import com.study.common.base.dto.ResultDto;
import com.study.common.base.error.codes.ErrorCodes;
import com.study.common.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Iterator;

/**
 * @author : zhaoxuan
 * @date : 2019/11/1
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(value = BizException.class)
    public ResultDto bizExceptionHandler(BizException bizException) {
        log.error("业务异常:{}", bizException.getErrorMsg());
        return new ResultDto(bizException);

    }

    /**
     * 文件异常
     */
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public ResultDto bizExceptionHandler(MaxUploadSizeExceededException exception) {
        log.error("文件异常:{}", exception.getMessage());
        return new ResultDto(ErrorCodes.FILE_EXCEED_MAX_SIZE , "");
    }

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResultDto bizExceptionHandler(MissingServletRequestParameterException exception) {
        log.error("业务异常:{}", exception.getMessage());
        return new ResultDto(ErrorCodes.ARGS_NOT_LEGAL, exception.getParameterName());
    }

    /**
     * 处理数据校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultDto bizExceptionHandler(MethodArgumentNotValidException exception) {
        log.error("参数异常:{}", exception.getMessage());
        Iterator var2 = exception.getBindingResult().getAllErrors().iterator();
        while (var2.hasNext()) {
            ObjectError error = (ObjectError) var2.next();
            return  ResultDto.fail(error.getDefaultMessage());
        }
        return ResultDto.fail(exception.getMessage());
    }

    /**
     * 权限异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public ResultDto unauthorizedExceptionHandler(UnauthorizedException exception) {
        String message = exception.getMessage();
        int start = message.indexOf("[") + 1;
        int end = message.indexOf("]");
        String pId = message.substring(start, end);
        return new ResultDto(ErrorCodes.SYS_ERROR_403);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResultDto exceptionHandler(Exception exception) {
        log.error("系统异常:{}", exception.getMessage(), exception);
        return new ResultDto(ErrorCodes.SYS_ERROR_500);
    }
}

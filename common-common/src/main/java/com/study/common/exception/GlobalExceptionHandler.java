package com.study.common.exception;

import com.study.common.base.dto.ResultDto;
import com.study.common.base.error.codes.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

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
    @ExceptionHandler(value = BaseException.class)
    public ResultDto bizExceptionHandler(BaseException bizException) {
        log.error("业务异常:{}", bizException.getErrorMsg());
        return ResultDto.fail(bizException);

    }

    /**
     * 文件异常
     */
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public ResultDto bizExceptionHandler(MaxUploadSizeExceededException exception) {
        log.error("文件异常:{}", exception.getMessage());
        return ResultDto.fail(ErrorCodes.FILE_EXCEED_MAX_SIZE, "");
    }

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResultDto bizExceptionHandler(MissingServletRequestParameterException exception) {
        log.error("业务异常:{}", exception.getMessage());
        return ResultDto.fail(ErrorCodes.ARGS_NOT_LEGAL, exception.getParameterName());
    }



    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResultDto exceptionHandler(Exception exception) {
        log.error("系统异常:{}", exception.getMessage(), exception);
        return ResultDto.fail(ErrorCodes.SYS_ERROR_500);
    }
}

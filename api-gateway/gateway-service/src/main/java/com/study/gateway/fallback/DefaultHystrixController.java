package com.study.gateway.fallback;

import com.study.common.base.dto.ResultDto;
import com.study.common.base.error.codes.ErrorCodes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultFallback")
    public ResultDto defaultFallback(){
        return ResultDto.fail(ErrorCodes.SYS_ERROR_BUSY);
    }
}
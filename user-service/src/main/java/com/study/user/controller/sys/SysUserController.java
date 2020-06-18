package com.study.user.controller.sys;


import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.Map;
import com.study.user.entity.sys.SysUser;
import com.study.common.core.web.controller.BaseController;
import com.study.user.service.sys.SysUserService;

/**
 *  前端控制器
 *
 * @author
 * @date Thu Jun 18 15:05:00 CST 2020
 */
@Api(value = "", tags = "")
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends  BaseController {


    @Autowired
    private  SysUserService  sysUserService;





}

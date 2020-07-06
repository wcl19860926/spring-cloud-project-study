package com.study.user.controller.sys;


import com.study.common.base.dto.PageParams;
import com.study.common.base.dto.ResultDto;
import com.study.common.core.web.controller.BaseController;
import com.study.user.service.sys.SysUserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "系统登录管理", tags = "系统用户登录，登出管理")
@RestController
@RequestMapping("/sysUser/manger")
public class SysUserManagerController extends BaseController {


    private static Logger logger = LoggerFactory.getLogger(SysUserManagerController.class);


    @Autowired
    private SysUserService sysUserService;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultDto login(PageParams pageParams) throws Exception {
        return ResultDto.success(sysUserService.selectList(pageParams));
    }


}

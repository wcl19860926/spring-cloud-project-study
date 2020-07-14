package com.study.user.controller.sys;


import com.study.common.base.dto.Page;
import com.study.common.base.dto.PageParams;
import com.study.common.base.dto.ResultDto;
import com.study.common.core.web.controller.BaseController;
import com.study.user.service.sys.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "用户权限管理", tags = "用户权限管理")
@RestController
@RequestMapping("/api/sysUser/manger")
public class SysUserManagerController extends BaseController {


    private static Logger logger = LoggerFactory.getLogger(SysUserManagerController.class);


    @Autowired
    private SysUserService sysUserService;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiImplicitParam(paramType = "body", name = "page", value = "分页参数", required = true, dataType = "Page")
    public ResultDto list(Page page) throws Exception {
        PageParams pageParams = new PageParams(page);
        return ResultDto.success(sysUserService.selectList(pageParams));
    }


}

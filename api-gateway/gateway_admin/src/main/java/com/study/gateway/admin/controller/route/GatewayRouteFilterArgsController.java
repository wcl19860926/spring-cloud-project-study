package com.study.gateway.admin.controller.route;


import com.study.common.core.web.controller.BaseController;
import com.study.gateway.admin.service.route.GatewayRouteFilterArgsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  前端控制器
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */
@Api(value = "", tags = "")
@RestController
@RequestMapping("/gatewayRouteFilterArgs")
public class GatewayRouteFilterArgsController extends  BaseController {


    @Autowired
    private  GatewayRouteFilterArgsService  gatewayRouteFilterArgsService;





}

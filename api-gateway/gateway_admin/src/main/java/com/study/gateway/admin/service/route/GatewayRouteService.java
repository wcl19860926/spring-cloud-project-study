package com.study.gateway.admin.service.route;

import com.study.common.core.mybaties.service.BaseService;
import com.study.gateway.admin.entity.route.GatewayRoute;

/**
 *  服务类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */

public interface GatewayRouteService  extends   BaseService<GatewayRoute , Long> {


    Integer  deleteByRouteId(String routeId);


    GatewayRoute  findByRouteId(String routeId);


}


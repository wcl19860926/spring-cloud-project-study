package com.study.gateway.admin.service.route;

import com.study.common.core.mybaties.service.BaseService;
import com.study.gateway.admin.dto.route.GatewayRouteFilterDto;
import com.study.gateway.admin.entity.route.GatewayRouteFilter;

import java.util.List;

/**
 *  服务类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */

public interface GatewayRouteFilterService  extends   BaseService<GatewayRouteFilter , Long> {


    Integer  deleteByRoteId(String routeId);

    List<GatewayRouteFilterDto>  findByRouteId(String routeId);
}


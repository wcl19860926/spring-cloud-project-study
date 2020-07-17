package com.study.gateway.admin.service.route.impl;

import com.study.common.base.dto.PageData;
import com.study.common.base.dto.PageQuery;
import com.study.common.base.dto.ResultDto;
import com.study.gateway.admin.dto.route.GatewayRouteDto;
import com.study.gateway.admin.entity.route.GatewayRoute;
import com.study.gateway.admin.service.route.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("routeManagerService")
public class RouteManagerServiceImpl implements RouteManagerService {


    @Autowired
    private GatewayRouteService gatewayRouteService;

    @Autowired
    private GatewayRouteFilterService gatewayRouteFilterService;

    @Autowired
    private GatewayRouteFilterArgsService gatewayRouteFilterArgsService;

    @Autowired
    private GatewayRoutePredicateService gatewayRoutePredicateService;

    @Autowired
    private GatewayRoutePredicateArgsService gatewayRoutePredicateArgsService;


    @Override
    public ResultDto<GatewayRouteDto> addGatewayRoute(GatewayRouteDto gatewayRouteDto) {
        return null;
    }

    @Override
    public ResultDto<GatewayRouteDto> updateGatewayRoute(GatewayRouteDto gatewayRouteDto) {
        return null;
    }

    @Override
    public ResultDto<Integer> deleteGatewayRoute(String routeId) {
        return null;
    }

    @Override
    public ResultDto<PageData<GatewayRoute>> queryRoutePageList(PageQuery pageQuery) {
        return null;
    }

    @Override
    public ResultDto<GatewayRouteDto> findRouteDetailByRouteId(String routeId) {
        return null;
    }
}

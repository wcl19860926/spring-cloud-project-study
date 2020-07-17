package com.study.gateway.admin.service.route;


import com.study.common.base.dto.PageData;
import com.study.common.base.dto.PageQuery;
import com.study.common.base.dto.ResultDto;
import com.study.gateway.admin.dto.route.GatewayRouteDto;
import com.study.gateway.admin.entity.route.GatewayRoute;

public interface RouteManagerService {


    ResultDto<GatewayRouteDto> addGatewayRoute(GatewayRouteDto gatewayRouteDto);


    ResultDto<GatewayRouteDto> updateGatewayRoute(GatewayRouteDto gatewayRouteDto);


    ResultDto<Integer> deleteGatewayRoute(String routeId);


    ResultDto<PageData<GatewayRoute>> queryRoutePageList(PageQuery pageQuery);


    ResultDto<GatewayRouteDto> findRouteDetailByRouteId(String routeId);


}

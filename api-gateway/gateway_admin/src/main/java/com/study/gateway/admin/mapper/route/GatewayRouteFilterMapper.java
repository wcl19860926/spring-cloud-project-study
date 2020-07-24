package com.study.gateway.admin.mapper.route;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.gateway.admin.entity.route.GatewayRouteFilter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface   GatewayRouteFilterMapper   extends  BaseMapper<GatewayRouteFilter , Long> {


    Integer  deleteByRoteId(String routeId);


}
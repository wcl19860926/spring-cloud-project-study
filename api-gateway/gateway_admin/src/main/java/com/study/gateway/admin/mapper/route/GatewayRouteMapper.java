package com.study.gateway.admin.mapper.route;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.gateway.admin.entity.route.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface   GatewayRouteMapper   extends  BaseMapper<GatewayRoute , Long> {

}
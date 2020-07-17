package com.study.gateway.admin.mapper.route;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.gateway.admin.entity.route.GatewayRoutePredicate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface   GatewayRoutePredicateMapper   extends  BaseMapper<GatewayRoutePredicate , Long> {

}
package com.study.gateway.admin.mapper.route;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.gateway.admin.entity.route.GatewayRoutePredicateArgs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface   GatewayRoutePredicateArgsMapper   extends  BaseMapper<GatewayRoutePredicateArgs , Long> {


    Integer  deleteByPredicateId(String predicateId);
}
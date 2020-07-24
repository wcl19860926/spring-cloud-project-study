package com.study.gateway.admin.mapper.route;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.gateway.admin.entity.route.GatewayRouteFilterArgs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface   GatewayRouteFilterArgsMapper   extends  BaseMapper<GatewayRouteFilterArgs , Long> {


    Integer  deleteByFilterId(String filterId);

}
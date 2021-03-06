package com.study.gateway.admin.service.route;

import com.study.common.core.mybaties.service.BaseService;
import com.study.gateway.admin.dto.route.GatewayRoutePredicateArgsDto;
import com.study.gateway.admin.entity.route.GatewayRoutePredicateArgs;

import java.util.List;

/**
 *  服务类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */

public interface GatewayRoutePredicateArgsService  extends   BaseService<GatewayRoutePredicateArgs , Long> {


    Integer  deleteByPredicateId(String predicateId);


    List<GatewayRoutePredicateArgsDto>  findByPredicateId(String predicateId);

}


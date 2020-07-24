package com.study.gateway.admin.service.route;

import com.study.common.core.mybaties.service.BaseService;
import com.study.gateway.admin.dto.route.GatewayRoutePredicateDto;
import com.study.gateway.admin.entity.route.GatewayRoutePredicate;
import io.swagger.models.auth.In;

import java.util.List;

/**
 *  服务类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */

public interface GatewayRoutePredicateService  extends   BaseService<GatewayRoutePredicate , Long> {


     Integer  deleteByRoteId(String roteId);


     List<GatewayRoutePredicateDto> findByRouteId(String routeId);
}


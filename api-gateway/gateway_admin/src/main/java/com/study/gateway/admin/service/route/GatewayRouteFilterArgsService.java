package com.study.gateway.admin.service.route;

import com.study.common.core.mybaties.service.BaseService;
import com.study.gateway.admin.dto.route.GatewayRouteFilterArgsDto;
import com.study.gateway.admin.dto.route.GatewayRoutePredicateArgsDto;
import com.study.gateway.admin.entity.route.GatewayRouteFilterArgs;
import com.study.gateway.admin.entity.route.GatewayRoutePredicateArgs;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  服务类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */

public interface GatewayRouteFilterArgsService  extends   BaseService<GatewayRouteFilterArgs , Long> {


    Integer  deleteByFilterId(String filterId);


     List<GatewayRouteFilterArgsDto> findByFilterId(String filterId) ;

}


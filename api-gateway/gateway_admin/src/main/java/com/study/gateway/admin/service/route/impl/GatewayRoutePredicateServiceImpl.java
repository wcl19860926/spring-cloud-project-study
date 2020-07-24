package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.dto.route.GatewayRoutePredicateDto;
import com.study.gateway.admin.entity.route.GatewayRoutePredicate;
import com.study.gateway.admin.mapper.route.GatewayRoutePredicateMapper;
import com.study.gateway.admin.service.route.GatewayRoutePredicateArgsService;
import com.study.gateway.admin.service.route.GatewayRoutePredicateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */
@Service(value = "gatewayRoutePredicateService")
public class GatewayRoutePredicateServiceImpl extends BaseServiceImpl<GatewayRoutePredicate, Long> implements GatewayRoutePredicateService {


    @Autowired
    private GatewayRoutePredicateMapper gatewayRoutePredicateMapper;


    @Autowired
    private GatewayRoutePredicateArgsService gatewayRoutePredicateArgsService;


    @Override
    public BaseMapper<GatewayRoutePredicate, Long> getMapper() {
        return gatewayRoutePredicateMapper;
    }


    @Override
    public Integer deleteByRoteId(String routeId) {

        Map<String, Object> params = new HashMap<>();
        params.put("routeId", routeId);
        List<GatewayRoutePredicate> gatewayRoutePredicateList = this.selectList(params);
        if (!CollectionUtils.isEmpty(gatewayRoutePredicateList)) {
            gatewayRoutePredicateList.forEach(predicate -> {
                gatewayRoutePredicateArgsService.deleteByPredicateId(predicate.getPredicateId());
            });
            return gatewayRoutePredicateMapper.deleteByRoteId(routeId);
        }

        return Integer.valueOf(0);
    }


    @Override
    public List<GatewayRoutePredicateDto> findByRouteId(String routeId) {
        List<GatewayRoutePredicateDto> dtoList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("routeId", routeId);
        List<GatewayRoutePredicate> gatewayRoutePredicateList = selectList(params);
        if (!CollectionUtils.isEmpty(gatewayRoutePredicateList)) {
            gatewayRoutePredicateList.forEach(predicate -> {
                GatewayRoutePredicateDto dto = new GatewayRoutePredicateDto();
                BeanUtils.copyProperties(predicate, dto);
                dtoList.add(dto);
            });
        }
        return dtoList;
    }
}

package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.dto.route.GatewayRoutePredicateArgsDto;
import com.study.gateway.admin.entity.route.GatewayRoutePredicateArgs;
import com.study.gateway.admin.mapper.route.GatewayRoutePredicateArgsMapper;
import com.study.gateway.admin.service.route.GatewayRoutePredicateArgsService;
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
@Service(value = "gatewayRoutePredicateArgsService")
public class GatewayRoutePredicateArgsServiceImpl extends BaseServiceImpl<GatewayRoutePredicateArgs, Long> implements GatewayRoutePredicateArgsService {


    @Autowired
    private GatewayRoutePredicateArgsMapper gatewayRoutePredicateArgsMapper;


    @Override
    public BaseMapper<GatewayRoutePredicateArgs, Long> getMapper() {
        return gatewayRoutePredicateArgsMapper;
    }


    @Override
    public Integer deleteByPredicateId(String predicateId) {
        return gatewayRoutePredicateArgsMapper.deleteByPredicateId(predicateId);
    }

    @Override
    public List<GatewayRoutePredicateArgsDto> findByPredicateId(String predicateId) {

        Map<String, Object> params = new HashMap<>();
        params.put("predicateId", predicateId);
        List<GatewayRoutePredicateArgs> gatewayRoutePredicateArgsList = selectList(params);
        List<GatewayRoutePredicateArgsDto> predicateArgsDtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(gatewayRoutePredicateArgsList)) {
            gatewayRoutePredicateArgsList.forEach(predicateArg -> {
                GatewayRoutePredicateArgsDto dto = new GatewayRoutePredicateArgsDto();
                BeanUtils.copyProperties(predicateArg, dto);
                predicateArgsDtoList.add(dto);
            });
        }
        return predicateArgsDtoList;
    }
}

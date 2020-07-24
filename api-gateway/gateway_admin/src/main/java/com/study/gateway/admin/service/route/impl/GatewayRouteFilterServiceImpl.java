package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.dto.route.GatewayRouteFilterDto;
import com.study.gateway.admin.entity.route.GatewayRouteFilter;
import com.study.gateway.admin.mapper.route.GatewayRouteFilterMapper;
import com.study.gateway.admin.service.route.GatewayRouteFilterArgsService;
import com.study.gateway.admin.service.route.GatewayRouteFilterService;
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
@Service(value = "gatewayRouteFilterService")
public class GatewayRouteFilterServiceImpl extends BaseServiceImpl<GatewayRouteFilter, Long> implements GatewayRouteFilterService {


    @Autowired
    private GatewayRouteFilterMapper gatewayRouteFilterMapper;


    @Autowired
    private GatewayRouteFilterArgsService gatewayRouteFilterArgsService;


    @Override
    public BaseMapper<GatewayRouteFilter, Long> getMapper() {
        return gatewayRouteFilterMapper;
    }


    @Override
    public Integer deleteByRoteId(String routeId) {
        Map<String, Object> params = new HashMap<>();
        params.put("routeId", routeId);
        List<GatewayRouteFilter> gatewayRouteFilterList = super.selectList(params);
        if (!CollectionUtils.isEmpty(gatewayRouteFilterList)) {
            gatewayRouteFilterList.forEach(filter -> {
                gatewayRouteFilterArgsService.deleteByFilterId(filter.getFilterId());
            });

            gatewayRouteFilterMapper.deleteByRoteId(routeId);
        }
        return Integer.valueOf(0);
    }

    @Override
    public List<GatewayRouteFilterDto> findByRouteId(String routeId) {
        Map<String, Object> params = new HashMap<>();
        params.put("routeId", routeId);
        List<GatewayRouteFilter> gatewayRouteFilterList = selectList(params);
        List<GatewayRouteFilterDto> dtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(gatewayRouteFilterList)) {
            gatewayRouteFilterList.forEach(filter -> {
                GatewayRouteFilterDto dto = new GatewayRouteFilterDto();
                BeanUtils.copyProperties(filter, dto);
                dto.setGatewayRouteFilterArgsDtoList(gatewayRouteFilterArgsService.findByFilterId(filter.getFilterId()));
                dtoList.add(dto);
            });
        }
        return dtoList;
    }
}

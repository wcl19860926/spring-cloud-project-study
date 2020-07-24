package com.study.gateway.admin.service.route.impl;

import com.study.common.base.dto.PageData;
import com.study.common.base.dto.PageQuery;
import com.study.common.base.dto.ResultDto;
import com.study.gateway.admin.dto.route.*;
import com.study.gateway.admin.entity.route.*;
import com.study.gateway.admin.service.route.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("routeManagerService")
public class RouteManagerServiceImpl implements RouteManagerService {


    @Autowired
    private GatewayRouteService gatewayRouteService;

    @Autowired
    private GatewayRouteFilterService gatewayRouteFilterService;

    @Autowired
    private GatewayRouteFilterArgsService gatewayRouteFilterArgsService;

    @Autowired
    private GatewayRoutePredicateService gatewayRoutePredicateService;

    @Autowired
    private GatewayRoutePredicateArgsService gatewayRoutePredicateArgsService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultDto<GatewayRouteDto> addGatewayRoute(GatewayRouteDto gatewayRouteDto) {
        GatewayRoute gatewayRoute = new GatewayRoute();
        BeanUtils.copyProperties(gatewayRouteDto, gatewayRoute);
        gatewayRouteService.insert(gatewayRoute);
        gatewayRouteDto.setId(gatewayRoute.getId());
        List<GatewayRouteFilterDto> gatewayRouteFilterDtoArrayList = gatewayRouteDto.getGatewayRouteFilterDtoArrayList();
        gatewayRouteFilterDtoArrayList.forEach(item -> {
            GatewayRouteFilter gatewayRouteFilter = new GatewayRouteFilter();
            BeanUtils.copyProperties(item, gatewayRouteFilter);
            gatewayRouteFilter.setRouteId(gatewayRoute.getRouteId());
            gatewayRouteFilterService.insert(gatewayRouteFilter);
            item.setId(gatewayRouteFilter.getId());
            List<GatewayRouteFilterArgsDto> gatewayRoutePredicateArgsDtoList = item.getGatewayRouteFilterArgsDtoList();
            if (!CollectionUtils.isEmpty(gatewayRoutePredicateArgsDtoList)) {
                gatewayRoutePredicateArgsDtoList.forEach(filterArgs -> {
                    GatewayRouteFilterArgs gatewayRouteFilterArgs = new GatewayRouteFilterArgs();
                    BeanUtils.copyProperties(filterArgs, gatewayRouteFilterArgs);
                    gatewayRouteFilterArgs.setFilterId(filterArgs.getFilterId());
                    gatewayRouteFilterArgsService.insert(gatewayRouteFilterArgs);
                    filterArgs.setId(gatewayRouteFilterArgs.getId());
                });
            }
        });
        List<GatewayRoutePredicateDto> gatewayRoutePredicateDtoArrayList = gatewayRouteDto.getGatewayRoutePredicateDtoArrayList();
        gatewayRoutePredicateDtoArrayList.forEach(predicate -> {
            GatewayRoutePredicate gatewayRoutePredicate = new GatewayRoutePredicate();
            BeanUtils.copyProperties(predicate, gatewayRoutePredicate);
            gatewayRoutePredicate.setRouteId(gatewayRoute.getRouteId());
            gatewayRoutePredicateService.insert(gatewayRoutePredicate);
            List<GatewayRoutePredicateArgsDto> gatewayRoutePredicateArgsDtoList = predicate.getGatewayRoutePredicateArgsDtoList();
            if (!CollectionUtils.isEmpty(gatewayRoutePredicateArgsDtoList)) {
                gatewayRoutePredicateArgsDtoList.forEach(predicateArg -> {
                    GatewayRoutePredicateArgs gatewayRoutePredicateArgs = new GatewayRoutePredicateArgs();
                    BeanUtils.copyProperties(predicateArg, gatewayRoutePredicateArgs);
                    gatewayRoutePredicateArgs.setPredicateId(predicateArg.getPredicateId());
                    gatewayRoutePredicateArgsService.insert(gatewayRoutePredicateArgs);
                    predicateArg.setId(gatewayRoutePredicateArgs.getId());
                });
            }
        });
        return ResultDto.success(gatewayRouteDto);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ResultDto<GatewayRouteDto> updateGatewayRoute(GatewayRouteDto gatewayRouteDto) {
        gatewayRouteService.deleteByRouteId(gatewayRouteDto.getRouteId());
        gatewayRouteFilterService.deleteByRoteId(gatewayRouteDto.getRouteId());
        gatewayRoutePredicateService.deleteByRoteId(gatewayRouteDto.getRouteId());
        return this.addGatewayRoute(gatewayRouteDto);
    }

    @Override
    public ResultDto<Integer> deleteGatewayRoute(String routeId) {

        gatewayRouteFilterService.deleteByRoteId(routeId);
        gatewayRoutePredicateService.deleteByRoteId(routeId);
        Integer count = gatewayRouteService.deleteByRouteId(routeId);
        return ResultDto.success(count);
    }

    @Override
    public ResultDto<PageData<GatewayRoute>> queryRoutePageList(PageQuery pageQuery) {
        return ResultDto.success(gatewayRouteService.selectByPage(pageQuery));
    }

    @Override
    public ResultDto<GatewayRouteDto> findRouteDetailByRouteId(String routeId) {
        GatewayRouteDto dto = new GatewayRouteDto();
        GatewayRoute gatewayRoute = gatewayRouteService.findByRouteId(routeId);
        BeanUtils.copyProperties(gatewayRoute, dto);
        dto.setGatewayRoutePredicateDtoArrayList(gatewayRoutePredicateService.findByRouteId(routeId));
        dto.setGatewayRouteFilterDtoArrayList(gatewayRouteFilterService.findByRouteId(routeId));
        return ResultDto.success(dto);
    }
}

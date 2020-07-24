package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.dto.route.GatewayRouteFilterArgsDto;
import com.study.gateway.admin.entity.route.GatewayRouteFilterArgs;
import com.study.gateway.admin.mapper.route.GatewayRouteFilterArgsMapper;
import com.study.gateway.admin.service.route.GatewayRouteFilterArgsService;
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
@Service(value = "gatewayRouteFilterArgsService")
public class GatewayRouteFilterArgsServiceImpl extends BaseServiceImpl<GatewayRouteFilterArgs, Long> implements GatewayRouteFilterArgsService {


    @Autowired
    private GatewayRouteFilterArgsMapper gatewayRouteFilterArgsMapper;


    @Override
    public BaseMapper<GatewayRouteFilterArgs, Long> getMapper() {
        return gatewayRouteFilterArgsMapper;
    }


    @Override
    public Integer deleteByFilterId(String filterId) {
        return gatewayRouteFilterArgsMapper.deleteByFilterId(filterId);
    }


    @Override
    public List<GatewayRouteFilterArgsDto> findByFilterId(String filterId) {

        Map<String, Object> params = new HashMap<>();
        params.put("filterId", filterId);
        List<GatewayRouteFilterArgs> gatewayRouteFilterArgsList = selectList(params);
        List<GatewayRouteFilterArgsDto> predicateArgsDtoList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(gatewayRouteFilterArgsList)) {
            gatewayRouteFilterArgsList.forEach(filterArgs -> {
                GatewayRouteFilterArgsDto dto = new GatewayRouteFilterArgsDto();
                BeanUtils.copyProperties(filterArgs, dto);
                predicateArgsDtoList.add(dto);
            });
        }
        return predicateArgsDtoList;
    }

}

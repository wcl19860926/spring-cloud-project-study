package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.entity.route.GatewayRoutePredicateArgs;
import com.study.gateway.admin.mapper.route.GatewayRoutePredicateArgsMapper;
import com.study.gateway.admin.service.route.GatewayRoutePredicateArgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */
@Service(value = "gatewayRoutePredicateArgsService")
public class GatewayRoutePredicateArgsServiceImpl extends  BaseServiceImpl<GatewayRoutePredicateArgs , Long> implements GatewayRoutePredicateArgsService{


       @Autowired
       private  GatewayRoutePredicateArgsMapper   gatewayRoutePredicateArgsMapper;


        @Override
        public  BaseMapper<GatewayRoutePredicateArgs , Long> getMapper(){
              return gatewayRoutePredicateArgsMapper;
        }


}

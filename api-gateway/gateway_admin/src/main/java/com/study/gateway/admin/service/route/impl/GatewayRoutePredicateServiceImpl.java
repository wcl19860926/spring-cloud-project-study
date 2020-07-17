package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.entity.route.GatewayRoutePredicate;
import com.study.gateway.admin.mapper.route.GatewayRoutePredicateMapper;
import com.study.gateway.admin.service.route.GatewayRoutePredicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */
@Service(value = "gatewayRoutePredicateService")
public class GatewayRoutePredicateServiceImpl extends  BaseServiceImpl<GatewayRoutePredicate , Long> implements GatewayRoutePredicateService{


       @Autowired
       private  GatewayRoutePredicateMapper   gatewayRoutePredicateMapper;


        @Override
        public  BaseMapper<GatewayRoutePredicate , Long> getMapper(){
              return gatewayRoutePredicateMapper;
        }


}

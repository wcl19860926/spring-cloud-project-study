package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.entity.route.GatewayRoute;
import com.study.gateway.admin.mapper.route.GatewayRouteMapper;
import com.study.gateway.admin.service.route.GatewayRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */
@Service(value = "gatewayRouteServiceImpl")
public class GatewayRouteServiceImpl extends  BaseServiceImpl<GatewayRoute , Long> implements GatewayRouteService{


       @Autowired
       private  GatewayRouteMapper   gatewayRouteMapper;


        @Override
        public  BaseMapper<GatewayRoute , Long> getMapper(){
              return gatewayRouteMapper;
        }


}

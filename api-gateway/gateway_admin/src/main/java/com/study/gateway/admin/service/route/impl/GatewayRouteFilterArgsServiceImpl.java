package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.entity.route.GatewayRouteFilterArgs;
import com.study.gateway.admin.mapper.route.GatewayRouteFilterArgsMapper;
import com.study.gateway.admin.service.route.GatewayRouteFilterArgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */
@Service(value = "gatewayRouteFilterArgsService")
public class GatewayRouteFilterArgsServiceImpl extends  BaseServiceImpl<GatewayRouteFilterArgs , Long> implements GatewayRouteFilterArgsService{


       @Autowired
       private  GatewayRouteFilterArgsMapper   gatewayRouteFilterArgsMapper;


        @Override
        public  BaseMapper<GatewayRouteFilterArgs , Long> getMapper(){
              return gatewayRouteFilterArgsMapper;
        }


}

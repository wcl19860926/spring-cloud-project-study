package com.study.gateway.admin.service.route.impl;

import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.gateway.admin.entity.route.GatewayRouteFilter;
import com.study.gateway.admin.mapper.route.GatewayRouteFilterMapper;
import com.study.gateway.admin.service.route.GatewayRouteFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author
 * @date Fri Jul 17 14:37:55 CST 2020
 */
@Service(value = "gatewayRouteFilterService")
public class GatewayRouteFilterServiceImpl extends  BaseServiceImpl<GatewayRouteFilter , Long> implements GatewayRouteFilterService{


       @Autowired
       private  GatewayRouteFilterMapper   gatewayRouteFilterMapper;


        @Override
        public  BaseMapper<GatewayRouteFilter , Long> getMapper(){
              return gatewayRouteFilterMapper;
        }


}

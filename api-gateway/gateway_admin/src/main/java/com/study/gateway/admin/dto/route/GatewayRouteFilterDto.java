package com.study.gateway.admin.dto.route;

import com.study.gateway.admin.entity.route.GatewayRouteFilter;
import lombok.Data;

import java.util.List;

@Data
public class GatewayRouteFilterDto  extends GatewayRouteFilter {

    List<GatewayRouteFilterArgsDto>   gatewayRouteFilterArgsDtoList;
}

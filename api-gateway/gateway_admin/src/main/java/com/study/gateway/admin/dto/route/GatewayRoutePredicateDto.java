package com.study.gateway.admin.dto.route;

import com.study.gateway.admin.entity.route.GatewayRoutePredicate;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GatewayRoutePredicateDto  extends GatewayRoutePredicate {

    private List<GatewayRoutePredicateArgsDto>  gatewayRoutePredicateArgsDtoList;
}

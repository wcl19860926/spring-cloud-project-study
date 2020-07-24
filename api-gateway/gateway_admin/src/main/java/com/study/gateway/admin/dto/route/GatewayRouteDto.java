package com.study.gateway.admin.dto.route;

import com.study.gateway.admin.entity.route.GatewayRoute;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
@Data
public class GatewayRouteDto  extends GatewayRoute {


    @NotEmpty
    @Valid
    private List<GatewayRouteFilterDto> gatewayRouteFilterDtoArrayList ;

    @Valid
    private List<GatewayRoutePredicateDto>  gatewayRoutePredicateDtoArrayList ;



}

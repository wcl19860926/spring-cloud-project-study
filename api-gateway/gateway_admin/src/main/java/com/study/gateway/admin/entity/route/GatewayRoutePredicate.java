package com.study.gateway.admin.entity.route;



import com.study.common.core.mybaties.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(value = "", description = "")
public  class  GatewayRoutePredicate  extends  BaseEntity<Long>{


private static final long serialVersionUID=1L;




/**
* route_id 关联路由表
*/
@ApiModelProperty(value = "route_id 关联路由表")
private   String  route_id;

/**
* 断言id
*/
@ApiModelProperty(value = "断言id")
private   String  predicate_id;

/**
* 断言名称
*/
@ApiModelProperty(value = "断言名称")
private   String  predicate_name;

/**
* 断言优先级
*/
@ApiModelProperty(value = "断言优先级")
private   Integer  predicate_priority;

/**
* 是否删除
*/
@ApiModelProperty(value = "是否删除")
private   Boolean  is_delete;

/**
* 创建时间
*/
@ApiModelProperty(value = "创建时间")
private   Date  create_time;

/**
* 更新时间
*/
@ApiModelProperty(value = "更新时间")
private Date update_time;

}

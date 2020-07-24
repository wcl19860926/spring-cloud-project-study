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
private   String  routeId;

/**
* 断言id
*/
@ApiModelProperty(value = "断言id")
private   String  predicateId;

/**
* 断言名称
*/
@ApiModelProperty(value = "断言名称")
private   String  predicateName;

/**
* 断言优先级
*/
@ApiModelProperty(value = "断言优先级")
private   Integer  predicatePriority;

/**
* 是否删除
*/
@ApiModelProperty(value = "是否删除")
private   Boolean  isDelete;

/**
* 创建时间
*/
@ApiModelProperty(value = "创建时间")
private Date createTime;

/**
* 更新时间
*/
@ApiModelProperty(value = "更新时间")
private   Date  updateTime;

}

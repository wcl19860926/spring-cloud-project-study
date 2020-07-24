package com.study.gateway.admin.entity.route;



import com.study.common.core.mybaties.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(value = "", description = "")
public  class  GatewayRouteFilter  extends  BaseEntity<Long>{


private static final long serialVersionUID=1L;



/**
* 关联路由表 router_id
*/
@ApiModelProperty(value = "关联路由表 router_id")
private   String  routeId;

/**
* 过滤器id
*/
@ApiModelProperty(value = "过滤器id")
private   String  filterId;

/**
* 过滤器名称
*/
@ApiModelProperty(value = "过滤器名称")
private   String  filterName;

/**
* 过滤器优先级
*/
@ApiModelProperty(value = "过滤器优先级")
private   Integer  filterPriority;

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

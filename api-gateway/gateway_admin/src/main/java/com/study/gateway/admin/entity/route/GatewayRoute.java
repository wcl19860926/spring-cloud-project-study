package com.study.gateway.admin.entity.route;



import com.study.common.core.mybaties.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(value = "", description = "")
public  class  GatewayRoute  extends  BaseEntity<Long>{


private static final long serialVersionUID=1L;



/**
* id
*/
@ApiModelProperty(value = "id")
private   Long  id;

/**
* 路由id
*/
@ApiModelProperty(value = "路由id")
private   String  routeId;

/**
* 路由系统id
*/
@ApiModelProperty(value = "路由系统id")
private   String  systemId;

/**
* 路由系统名称
*/
@ApiModelProperty(value = "路由系统名称")
private   String  systemName;

/**
* uri
*/
@ApiModelProperty(value = "uri")
private   String  routeUri;

/**
* 优先级
*/
@ApiModelProperty(value = "优先级")
private   Integer  routePriority;

/**
* 是否删除
*/
@ApiModelProperty(value = "是否删除")
private   Boolean  isDelete;

/**
* 创建时间
*/
@ApiModelProperty(value = "创建时间")
private   Date  createTime;

/**
* 更新时间
*/
@ApiModelProperty(value = "更新时间")
private Date updateTime;

}

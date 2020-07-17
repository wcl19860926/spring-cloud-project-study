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
* 路由id
*/
@ApiModelProperty(value = "路由id")
private   String  route_id;

/**
* 路由系统id
*/
@ApiModelProperty(value = "路由系统id")
private   String  system_id;

/**
* 路由系统名称
*/
@ApiModelProperty(value = "路由系统名称")
private   String  system_name;

/**
* uri
*/
@ApiModelProperty(value = "uri")
private   String  route_uri;

/**
* 优先级
*/
@ApiModelProperty(value = "优先级")
private   Integer  route_priority;

/**
* 是否删除
*/
@ApiModelProperty(value = "是否删除")
private   Boolean  is_delete;

/**
* 创建时间
*/
@ApiModelProperty(value = "创建时间")
private Date create_time;

/**
* 更新时间
*/
@ApiModelProperty(value = "更新时间")
private   Date  update_time;

}

package com.study.gateway.admin.entity.route;



import com.study.common.core.mybaties.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(value = "", description = "")
public  class  GatewayRouteFilterArgs  extends  BaseEntity<Long>{


private static final long serialVersionUID=1L;





/**
* 关联过滤器表 filter_id
*/
@ApiModelProperty(value = "关联过滤器表 filter_id")
private   String  filterId;

/**
* 过滤器参数id
*/
@ApiModelProperty(value = "过滤器参数id")
private   String  filterArgsId;

/**
* 参数名
*/
@ApiModelProperty(value = "参数名")
private   String  argsName;

/**
* 参数值
*/
@ApiModelProperty(value = "参数值")
private   String  argsValue;

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

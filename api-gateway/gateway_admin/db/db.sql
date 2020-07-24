/*==============================================================*/
/* Table: gateway_route                                         */
/*==============================================================*/
create table gateway_route
(
   id                   bigint unsigned not null  comment 'id',
   routeId             varchar(30) not null comment '路由id',
   systemId            varchar(30) not null default '' comment '路由系统id',
   systemName          varchar(50) not null default '' comment '路由系统名称',
   routeUri            varchar(50) not null default '' comment 'uri',
   routePriority       int not null default 0 comment '优先级',
   isDelete            tinyint(1) unsigned not null default 0 comment '是否删除',
   createTime          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updateTime          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_route_id (routeId)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='路由表';



/*==============================================================*/
/* Table: route_predicate                                       */
/*==============================================================*/
create table gateway_route_predicate
(
   id                   bigint unsigned not null  comment 'id',
   routeId             varchar(30) not null default '' comment 'route_id 关联路由表',
   predicateId         varchar(30) not null comment '断言id',
   predicateName       varchar(50) not null default '' comment '断言名称',
   predicatePriority   int not null default 0 comment '断言优先级',
   isDelete            tinyint(1) unsigned not null default 0 comment '是否删除',
   createTime          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updateTime          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_predicate_id (predicateId)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='路由断言表';



/*==============================================================*/
/* Table: route_predicate_args                                  */
/*==============================================================*/
create table gateway_route_predicate_args
(
   id                   bigint unsigned not null  comment 'id',
   predicateId         varchar(30) not null default '' comment '关联断言表 predicate_id',
   predicateArgId     varchar(30) not null comment '断言参数id',
   argsName            varchar(100) not null comment '参数名',
   argsValue           varchar(255) not null comment '参数值',
   isDelete            tinyint(1) unsigned not null default 0 comment '是否删除',
   createTime          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updateTime          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_predicate_arg_id (predicateArgId)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='断言参数表';



/*==============================================================*/
/* Table: route_filter                                          */
/*==============================================================*/
create table gateway_route_filter
(
   id                   bigint unsigned not null  comment 'id',
   routeId             varchar(30) not null default '' comment '关联路由表 router_id',
   filterId            varchar(30) not null comment '过滤器id',
   filterName          varchar(100) not null default '' comment '过滤器名称',
   filterPriority      int not null default 0 comment '过滤器优先级',
   isDelete            tinyint(1) unsigned not null default 0 comment '是否删除',
   createTime          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updateTime          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_filter_id (filterId)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='路由过滤器表';




/*==============================================================*/
/* Table: route_filter_args                                     */
/*==============================================================*/
create table gateway_route_filter_args
(
   id                   bigint unsigned not null  comment 'id',
   filterId            varchar(30) not null default '' comment '关联过滤器表 filter_id',
   filterArgsId       varchar(30) not null comment '过滤器参数id',
   argsName            varchar(100) not null comment '参数名',
   argsValue           varchar(255) not null comment '参数值',
   isDelete            tinyint(1) unsigned not null default 0 comment '是否删除',
   createTime          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   updateTime          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_filter_args_id (filterArgsId)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='路由过滤器参数表';
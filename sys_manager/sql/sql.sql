CREATE TABLE sys_user_online (
     id VARCHAR (32) NOT NULL COMMENT '主建',
     sessionId VARCHAR (50) DEFAULT '' COMMENT '用户会话id',
     loginName VARCHAR (50) DEFAULT '' COMMENT '登录账号',
     deptCode VARCHAR (50) DEFAULT '' COMMENT '部门编号',
     ipaddr VARCHAR (50) DEFAULT '' COMMENT '登录IP地址',
     loginLocation VARCHAR (255) DEFAULT '' COMMENT '登录地点',
     browser VARCHAR (50) DEFAULT '' COMMENT '浏览器类型',
     os VARCHAR (50) DEFAULT '' COMMENT '操作系统',
     STATUS VARCHAR (10) DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
     startTimestamp datetime COMMENT 'session创建时间',
     lastAccessTime datetime COMMENT 'session最后访问时间',
     expireTime INT (5) DEFAULT 0 COMMENT '超时时间，单位为分钟',
     PRIMARY KEY (id)
) ENGINE = INNODB COMMENT = '系统用户在线记录表';

CREATE TABLE sys_login_info (
    id VARCHAR (32) NOT NULL COMMENT '主建',
    loginName VARCHAR (50) DEFAULT '' COMMENT '登录账号',
    ipaddr VARCHAR (50) DEFAULT '' COMMENT '登录IP地址',
    loginLocation VARCHAR (255) DEFAULT '' COMMENT '登录地点',
    browser VARCHAR (50) DEFAULT '' COMMENT '浏览器类型',
    os VARCHAR (50) DEFAULT '' COMMENT '操作系统',
    STATUS CHAR (1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
    msg VARCHAR (255) DEFAULT '' COMMENT '提示消息',
    loginTime datetime COMMENT '访问时间',
    PRIMARY KEY (id)
) ENGINE = INNODB COMMENT = '系统用户登录记录表';

CREATE TABLE sys_config (
    id VARCHAR (32) NOT NULL COMMENT '主建',
    configName VARCHAR (100) DEFAULT '' COMMENT '参数名称',
    configKey VARCHAR (100) DEFAULT '' COMMENT '参数键名',
    configValue VARCHAR (500) DEFAULT '' COMMENT '参数键值',
    configType CHAR (1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
    isDeleted bit (1) DEFAULT b '0' COMMENT '逻辑删除 1：删除 0：未删除',
    createBy VARCHAR (64) DEFAULT '' COMMENT '创建者',
    createTime datetime COMMENT '创建时间',
    updateBy VARCHAR (64) DEFAULT '' COMMENT '更新者',
    updateTime datetime COMMENT '更新时间',
    remark VARCHAR (500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (id)
) ENGINE = INNODB COMMENT = '系统参数配置表';

CREATE TABLE sys_dict_type (
   id VARCHAR (32) NOT NULL COMMENT '主建',
   dictName VARCHAR (100) DEFAULT '' COMMENT '字典名称',
   dictType VARCHAR (100) DEFAULT '' COMMENT '字典类型',
   STATUS CHAR (1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
   isDeleted bit (1) DEFAULT b '0' COMMENT '逻辑删除 1：删除 0：未删除',
   createBy VARCHAR (64) DEFAULT '' COMMENT '创建者',
   createTime datetime COMMENT '创建时间',
   updateBy VARCHAR (64) DEFAULT '' COMMENT '更新者',
   updateTime datetime COMMENT '更新时间',
   remark VARCHAR (500) DEFAULT NULL COMMENT '备注',
   PRIMARY KEY (id),
   UNIQUE (dictType)
) ENGINE = INNODB COMMENT = '字典类型表';

CREATE TABLE sys_dict_data (
   id VARCHAR (32) NOT NULL COMMENT '主建',
   dictCode VARCHAR (32) NOT NULL COMMENT '字典编码',
   dictSort INT (4) DEFAULT 0 COMMENT '字典排序',
   dictLabel VARCHAR (100) DEFAULT '' COMMENT '字典标签',
   dictValue VARCHAR (100) DEFAULT '' COMMENT '字典键值',
   dictType VARCHAR (100) DEFAULT '' COMMENT '字典类型',
   isDefault CHAR (1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
   STATUS CHAR (1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
   isDeleted bit (1) DEFAULT b '0' COMMENT '逻辑删除 1：删除 0：未删除',
   createBy VARCHAR (64) DEFAULT '' COMMENT '创建者',
   createTime datetime COMMENT '创建时间',
   updateBy VARCHAR (64) DEFAULT '' COMMENT '更新者',
   updateTime datetime COMMENT '更新时间',
   remark VARCHAR (500) DEFAULT NULL COMMENT '备注',
   PRIMARY KEY (id)
) ENGINE = INNODB COMMENT = '字典数据表';

DROP TABLE
    IF EXISTS sys_oper_log;

CREATE TABLE sys_oper_log (
      id VARCHAR (32) NOT NULL COMMENT '主建',
      title VARCHAR (50) DEFAULT '' COMMENT '模块标题',
      businessType INT (2) DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
      method VARCHAR (100) DEFAULT '' COMMENT '方法名称',
      requestMethod VARCHAR (10) DEFAULT '' COMMENT '请求方式',
      operatorType INT (1) DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
      operName VARCHAR (50) DEFAULT '' COMMENT '操作人员',
      deptName VARCHAR (50) DEFAULT '' COMMENT '部门名称',
      operUrl VARCHAR (255) DEFAULT '' COMMENT '请求URL',
      operIp VARCHAR (50) DEFAULT '' COMMENT '主机地址',
      operLocation VARCHAR (255) DEFAULT '' COMMENT '操作地点',
      operParam VARCHAR (2000) DEFAULT '' COMMENT '请求参数',
      jsonResult VARCHAR (2000) DEFAULT '' COMMENT '返回参数',
      STATUS INT (1) DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
      errorMsg VARCHAR (2000) DEFAULT '' COMMENT '错误消息',
      operTime datetime COMMENT '操作时间',
      isDeleted bit (1) DEFAULT b '0' COMMENT '逻辑删除 1：删除 0：未删除',
      PRIMARY KEY (id)
) ENGINE = INNODB COMMENT = '操作日志记录';

CREATE TABLE sys_menu (
      id VARCHAR (32) NOT NULL COMMENT '主建',
      menuCode VARCHAR (20) NOT NULL COMMENT '菜单编码',
      menuName VARCHAR (50) NOT NULL COMMENT '菜单名称',
      parentCode BIGINT (20) DEFAULT 0 COMMENT '父菜单ID',
      orderNum INT (4) DEFAULT 0 COMMENT '显示顺序',
      url VARCHAR (200) DEFAULT '#' COMMENT '请求地址',
      target VARCHAR (20) DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
      menuType CHAR (1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
      visible CHAR (1) DEFAULT 0 COMMENT '菜单状态（0显示 1隐藏）',
      icon VARCHAR (100) DEFAULT '#' COMMENT '菜单图标',
      isDeleted bit (1) DEFAULT b '0' COMMENT '逻辑删除 1：删除 0：未删除',
      createBy VARCHAR (64) DEFAULT '' COMMENT '创建者',
      createTime datetime COMMENT '创建时间',
      updateBy VARCHAR (64) DEFAULT '' COMMENT '更新者',
      updateTime datetime COMMENT '更新时间',
      remark VARCHAR (500) DEFAULT '' COMMENT '备注',
      PRIMARY KEY (id) ， UNIQUE (menuCode)
) ENGINE = INNODB COMMENT = '菜单表';

CREATE TABLE sys_dept (
      id VARCHAR (32) NOT NULL COMMENT '主建',
      deptCode BIGINT (20) NOT COMMENT '部门id',
      parentCode BIGINT (20) DEFAULT 0 COMMENT '父部门编码',
      ancestors VARCHAR (50) DEFAULT '' COMMENT '祖级列表',
      deptName VARCHAR (30) DEFAULT '' COMMENT '部门名称',
      orderNum INT (4) DEFAULT 0 COMMENT '显示顺序',
      leader VARCHAR (20) DEFAULT NULL COMMENT '负责人',
      phone VARCHAR (11) DEFAULT NULL COMMENT '联系电话',
      email VARCHAR (50) DEFAULT NULL COMMENT '邮箱',
      STATUS CHAR (1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
      isDeleted bit (1) DEFAULT b '0' COMMENT '逻辑删除 1：删除 0：未删除',
      createBy VARCHAR (64) DEFAULT '' COMMENT '创建者',
      createTime datetime COMMENT '创建时间',
      updateBy VARCHAR (64) DEFAULT '' COMMENT '更新者',
      updateTime datetime COMMENT '更新时间',
      PRIMARY KEY (id)
) ENGINE = INNODB COMMENT = '部门表';


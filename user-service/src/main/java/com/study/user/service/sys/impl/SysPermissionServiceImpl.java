package com.study.user.service.sys.impl;

import com.study.user.entity.sys.SysPermission;
import com.study.user.mapper.sys.SysPermissionMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.user.service.sys.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  服务实现类
 *
 * @author
 * @date Thu Jun 18 15:05:00 CST 2020
 */
@Service(value = "sysPermissionServiceImpl")
public class SysPermissionServiceImpl extends  BaseServiceImpl<SysPermission , String> implements SysPermissionService{


       @Autowired
       private  SysPermissionMapper   sysPermissionMapper;


        @Override
        public  BaseMapper<SysPermission , String> getMapper(){
              return sysPermissionMapper;
        }


}

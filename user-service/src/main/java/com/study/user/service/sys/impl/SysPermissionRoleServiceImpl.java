package com.study.user.service.sys.impl;

import com.study.user.entity.sys.SysPermissionRole;
import com.study.user.mapper.sys.SysPermissionRoleMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.user.service.sys.SysPermissionRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  服务实现类
 *
 * @author
 * @date Thu Jun 18 15:05:00 CST 2020
 */
@Service(value = "sysPermissionRoleServiceImpl")
public class SysPermissionRoleServiceImpl extends  BaseServiceImpl<SysPermissionRole , String> implements SysPermissionRoleService{


       @Autowired
       private  SysPermissionRoleMapper   sysPermissionRoleMapper;


        @Override
        public  BaseMapper<SysPermissionRole , String> getMapper(){
              return sysPermissionRoleMapper;
        }


}

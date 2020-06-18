package com.study.user.service.sys.impl;

import com.study.user.entity.sys.SysRoleUser;
import com.study.user.mapper.sys.SysRoleUserMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.user.service.sys.SysRoleUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  服务实现类
 *
 * @author
 * @date Thu Jun 18 15:05:00 CST 2020
 */
@Service(value = "sysRoleUserServiceImpl")
public class SysRoleUserServiceImpl extends  BaseServiceImpl<SysRoleUser , String> implements SysRoleUserService{


       @Autowired
       private  SysRoleUserMapper   sysRoleUserMapper;


        @Override
        public  BaseMapper<SysRoleUser , String> getMapper(){
              return sysRoleUserMapper;
        }


}

package com.study.user.service.sys.impl;

import com.study.user.entity.sys.SysUser;
import com.study.user.mapper.sys.SysUserMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.user.service.sys.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  服务实现类
 *
 * @author
 * @date Thu Jun 18 15:05:00 CST 2020
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl extends  BaseServiceImpl<SysUser , String> implements SysUserService{


       @Autowired
       private  SysUserMapper   sysUserMapper;


        @Override
        public  BaseMapper<SysUser , String> getMapper(){
              return sysUserMapper;
        }


}

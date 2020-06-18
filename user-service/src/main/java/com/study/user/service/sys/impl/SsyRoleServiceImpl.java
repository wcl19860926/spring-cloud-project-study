package com.study.user.service.sys.impl;

import com.study.user.entity.sys.SsyRole;
import com.study.user.mapper.sys.SsyRoleMapper;
import com.study.common.core.mybaties.service.impl.BaseServiceImpl;
import com.study.common.core.mybaties.mapper.BaseMapper;
import com.study.user.service.sys.SsyRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  服务实现类
 *
 * @author
 * @date Thu Jun 18 15:05:00 CST 2020
 */
@Service(value = "ssyRoleServiceImpl")
public class SsyRoleServiceImpl extends  BaseServiceImpl<SsyRole , String> implements SsyRoleService{


       @Autowired
       private  SsyRoleMapper   ssyRoleMapper;


        @Override
        public  BaseMapper<SsyRole , String> getMapper(){
              return ssyRoleMapper;
        }


}

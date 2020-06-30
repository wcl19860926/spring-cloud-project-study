package com.study.user.service.biz.impl;

import com.study.user.entity.sys.SysPermission;
import com.study.user.entity.sys.SysRole;
import com.study.user.service.biz.RightManagerService;
import com.study.user.service.sys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rightManagerService")
public class RightManagerServiceImpl  implements RightManagerService {


    @Autowired
    private SysUserService  sysUserService;

    @Autowired
    private SysRoleUserService  sysRoleUserService;


    @Autowired
    private SysPermissionRoleService  sysPermissionRoleService;

    @Autowired
    private SysPermissionService  sysPermissionService;

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 通过UserId 查询用户对应的角色
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> findRolesByUserId(String userId) {
        return null;
    }
    /**
     * 通过角色Id查询角色对应的权限
     * @param roleId
     * @return
     */
    @Override
    public List<SysPermission> findPermissionsByRoleId(String roleId) {
        return null;
    }

    /**
     * 通过角色Ids批量查询角色对应的权限信息
     * @param roleIds
     * @return
     */
    @Override
    public List<SysPermission> findPermissionsByRoleIds(List<String> roleIds) {
        return null;
    }
}

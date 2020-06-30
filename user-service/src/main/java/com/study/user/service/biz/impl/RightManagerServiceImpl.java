package com.study.user.service.biz.impl;

import com.study.common.util.EntityUtils;
import com.study.user.entity.sys.SysPermission;
import com.study.user.entity.sys.SysPermissionRole;
import com.study.user.entity.sys.SysRole;
import com.study.user.entity.sys.SysRoleUser;
import com.study.user.service.biz.RightManagerService;
import com.study.user.service.sys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("rightManagerService")
public class RightManagerServiceImpl implements RightManagerService {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleUserService sysRoleUserService;


    @Autowired
    private SysPermissionRoleService sysPermissionRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 通过UserId 查询用户对应的角色
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> findRolesByUserId(String userId) {
        List<SysRoleUser> sysRoleUserList = sysRoleUserService.findByUserId(userId);
        if (!CollectionUtils.isEmpty(sysRoleUserList)) {
            List<Integer> roleIds = EntityUtils.applyProperty(sysRoleUserList, SysRoleUser::getRoleId);
            return sysRoleService.queryByRoleIds(roleIds);
        }
        return new ArrayList<>();
    }

    /**
     * 通过角色Id查询角色对应的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysPermission> findPermissionsByRoleId(Integer roleId) {
        List<SysPermissionRole> sysPermissionRoleList = sysPermissionRoleService.findByRoleId(roleId);
        if (!CollectionUtils.isEmpty(sysPermissionRoleList)) {
            List<Integer> permissionIds = EntityUtils.applyProperty(sysPermissionRoleList, SysPermissionRole::getPermissionId);
            return sysPermissionService.queryByPermissionIds(permissionIds);
        }
        return new ArrayList<>();
    }

    /**
     * 通过角色Ids批量查询角色对应的权限信息
     *
     * @param roleIds
     * @return
     */
    @Override
    public List<SysPermission> findPermissionsByRoleIds(List<Integer> roleIds) {
        List<SysPermissionRole> sysPermissionRoleList = sysPermissionRoleService.findByRoleIds(roleIds);
        if (!CollectionUtils.isEmpty(sysPermissionRoleList)) {
            List<Integer> permissionIds = EntityUtils.applyProperty(sysPermissionRoleList, SysPermissionRole::getPermissionId);
            return sysPermissionService.queryByPermissionIds(permissionIds);
        }
        return new ArrayList<>();
    }

    /**
     * 通过UserId 查询用户对应的权限信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysPermission> findPermissionsByUserId(String userId) {
        List<SysRole> sysRoles = this.findRolesByUserId(userId);
        if (CollectionUtils.isEmpty(sysRoles)) {
            List<Integer>  roleIds  = EntityUtils.applyProperty(sysRoles , SysRole::getId)
        }
        return  new ArrayList<>();
    }
}

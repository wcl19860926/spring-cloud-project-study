package com.study.user.service.biz;


import com.study.user.entity.sys.SysPermission;
import com.study.user.entity.sys.SysRole;

import java.util.List;

public interface RightManagerService {


    /**
     * 通过UserId 查询用户对应的角色
     * @param userId
     * @return
     */
    List<SysRole>  findRolesByUserId(String userId);


    /**
     * 通过角色Id查询角色对应的权限
     * @param roleId
     * @return
     */
    List<SysPermission>  findPermissionsByRoleId(Integer roleId);



    /**
     * 通过角色Ids批量查询角色对应的权限信息
     * @param roleIds
     * @return
     */
    List<SysPermission>  findPermissionsByRoleIds(List<Integer> roleIds);


    /**
     * 通过UserId 查询用户对应的权限信息
     * @param userId
     * @return
     */
    List<SysPermission>  findPermissionsByUserId(String userId);
}

package com.study.user.config.shiro;

import com.study.common.core.shiro.CusAuthenticationInfo;
import com.study.user.service.sys.SysRoleService;
import com.study.user.service.sys.SysPermissionService;
import com.study.user.service.sys.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceRealm extends AuthorizingRealm {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService SsyRoleService;


    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 认证信息
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     */
    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authonToken) throws AuthenticationException {

        String loginName = (String) authonToken.getPrincipal();

      /*  User user = null ;//userService.findUser(loginName);
        if (user == null) {
            // 没找到帐号
            throw new UnknownAccountException();
        }
        if (user.getIsLocked()) {
            throw new LockedAccountException();
        }
*/
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new CusAuthenticationInfo();
     /*           UserTypes.OSS,
                // 用户ID
                String.valueOf(user.getId()),
                // 用户名
                user.getUserName(),
                // 密码
                user.getPassword(),
                // salt=username+salt,采用明文访问时，不需要此句
                ByteSource.Util.bytes(user.getCredentialSalt()),
                // realm name
                getName()
        );*/
        return authenticationInfo;
    }



    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }





    /**
     * 权限信息
     * @param
     * //通过用户名去获得用户的所有资源，并把资源存入info中
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
       /* authorizationInfo.addRoles(permissionInfo.getRolesArray());
        authorizationInfo.addStringPermissions(permissionInfo.getPermissionArray());*/
        return authorizationInfo;
    }

    protected boolean isPermitted(Permission permission, AuthorizationInfo info) {
       /* if (!PrincipalUtils.getPrincipalManager().hasPrincipal()) {
            return false;
        } else {
            return PrincipalUtils.getPrincipalManager().isRoot() ? true : super.isPermitted(permission, info);
        }*/
        return true;
    }
}
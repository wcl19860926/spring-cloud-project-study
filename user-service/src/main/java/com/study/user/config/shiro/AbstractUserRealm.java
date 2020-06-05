package com.study.user.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public abstract class AbstractUserRealm extends AuthorizingRealm {
    public AbstractUserRealm() {
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

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
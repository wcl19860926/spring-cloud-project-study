package com.study.common.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

/**
 * @author : zhaoxuan
 * @date : 2019/11/29
 */
public abstract class AbstractAuthorizingRealm extends AuthorizingRealm {

    /**
     * token类型支持限定
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 授权操作
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(getRoles());
        authorizationInfo.addStringPermissions(getPermissions());
        return authorizationInfo;
    }

    protected abstract List<String> getRoles();

    protected abstract List<String> getPermissions();

    @Override
    protected boolean isPermitted(Permission permission, AuthorizationInfo info) {
        return super.isPermitted(permission, info);
    }
}

package com.study.user.config.shiro;

import com.study.common.core.shiro.CusAuthenticationInfo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

/**
 *
 * @author xiquee.com. <br>
 * @date 2018-11-09 10:16:00
 */
public class UserRealm extends AbstractUserRealm {

/*
    @Autowired
    @Lazy
    private UserService userService;*/

    /**
     * 验证当前登录的Subject
     * LoginController.login()方法中执行Subject.login()时 执行此方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        String loginName = (String) authcToken.getPrincipal();

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
}
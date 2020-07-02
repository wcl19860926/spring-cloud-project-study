package com.study.user.config.shiro;


import com.study.user.security.shiro.config.AbstractShiroConfig;
import com.study.user.security.shiro.constants.Constants;
import com.study.user.security.shiro.matcher.RetryLimitHashedCredentialsMatcher;
import com.study.user.security.shiro.realm.UserServiceRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ShiroConfiguration <br>
 *
 * @author xiquee.com <br>
 * @date 2018-11-09 10:16:00
 */
@Configuration
public class ShiroConfiguration extends AbstractShiroConfig {

    /**
     * Shiro的Web过滤器Factory 命名:shiroFilter<br />
     *
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        /*定义shiro过滤器,例如实现自定义的FormAuthenticationFilter，需要继承FormAuthenticationFilter
         */
        /*定义shiro过滤链  Map结构
         * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
         * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
         * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- 过滤链定义，从上向下顺序执行
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/api/v1/about", "anon");
        filterChainDefinitionMap.put("/api/v1/olddata/**", "anon");
        filterChainDefinitionMap.put("/api/v1/auth/**", "anon");
        filterChainDefinitionMap.put("/api/v1/flight/notice/**", "anon");
        filterChainDefinitionMap.put("/api/v1/**", "authc,kickout");
        filterChainDefinitionMap.put("/**", "anon");
        return createShiroFilterFactoryBean(securityManager, filterChainDefinitionMap);
    }

    /**
     * Shiro Realm
     */
    @Bean
    public UserServiceRealm createUserRealm() {
        UserServiceRealm userRealm = new UserServiceRealm();
        //告诉realm,使用credentialsMatcher加密算法类来验证密文
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        userRealm.setCachingEnabled(false);

        return userRealm;
    }

    @Override
    protected List<AuthorizingRealm> authorizingRealms() {
        return null;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码;
     * ）
     * 可以扩展凭证匹配器，实现 输入密码错误次数后锁定等功能，下一次
     *
     * @return
     */
    @Override
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher =
                new RetryLimitHashedCredentialsMatcher(cacheManager());

        // 散列算法:这里使用MD5算法;
        retryLimitHashedCredentialsMatcher.setHashAlgorithmName(Constants.HASH_ALGORITHM_NAME);
        // 散列的次数，比如散列两次，相当于 md5(md5(""));
        retryLimitHashedCredentialsMatcher.setHashIterations(Constants.HASH_ITERATIONS);
        // storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
        retryLimitHashedCredentialsMatcher.setStoredCredentialsHexEncoded(Constants.USE_HEX_ENCODED);

        return retryLimitHashedCredentialsMatcher;
    }


    public Cookie getCookie() {
        return new SimpleCookie("OPERATION_JSESSIONID");
    }
}


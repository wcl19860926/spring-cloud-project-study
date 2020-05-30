package com.study.common.core.shiro.config;

import com.study.common.core.shiro.ShiroSessionManager;
import com.study.common.core.shiro.cache.ShiroRedisCacheManager;
import com.study.common.core.shiro.filter.CusFormAuthenticationFilter;
import com.study.common.core.shiro.filter.CusPermissionsAuthorizationFilter;
import com.study.common.core.shiro.filter.CusRolesAuthorizationFilter;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.AbstractSessionManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : zhaoxuan
 * @date : 2019/12/4
 */
public abstract class AbstractShiroConfig {

    private static final int entryTimes = 1024;
    private static final String MD5 = "MD5";
    private static final String cookName = "DCS_JSESSIONID";
    private static final String cacheName = "shiro_SessionCache";

    protected abstract List<AuthorizingRealm> authorizingRealms();


    protected String setCookName() {
        return cookName;
    }

    protected String setCacheName() {
        return cacheName;
    }

    protected ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager, Map<String, String> filterChain) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.getFilters().put("authc", new CusFormAuthenticationFilter());
        shiroFilterFactoryBean.getFilters().put("roles", new CusRolesAuthorizationFilter());
        shiroFilterFactoryBean.getFilters().put("perms", new CusPermissionsAuthorizationFilter());
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChain);
        return shiroFilterFactoryBean;
    }

    @Bean
    protected SecurityManager securityManager(SessionManager sessionManager, @Qualifier("shiroCacheManager") CacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setAuthenticator(getModularRealmAuthenticator());
        List<Realm> reams = new ArrayList<>();
        if (authorizingRealms() != null) {
            reams.addAll(authorizingRealms());
        }
        securityManager.setRealms(reams);
        if (cacheManager != null) {
            securityManager.setCacheManager(cacheManager);
        }
        if (sessionManager != null) {
            securityManager.setSessionManager(sessionManager);
        }
        return securityManager;
    }

    @Bean
    public DefaultSessionManager sessionManager(SessionDAO sessionDAO) {
        ShiroSessionManager manager = new ShiroSessionManager();
        manager.setSessionDAO(sessionDAO);
        long timeout = getGlobalSessionOut();
        if (timeout > 0) {
            manager.setGlobalSessionTimeout(timeout);
            manager.setSessionValidationInterval(timeout);
        }
        manager.setSessionIdCookieEnabled(true);
        SimpleCookie cookie = new SimpleCookie(setCookName());
        manager.setSessionIdCookie(cookie);
        return manager;
    }

    @Bean("shiroCacheManager")
    public CacheManager cacheManager() {
        return new ShiroRedisCacheManager();
    }

    @Bean
    public SessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setActiveSessionsCacheName(setCacheName());
        return sessionDAO;
    }

    /**
     * 多realm验证,一个通过即可
     */
    protected Authenticator getModularRealmAuthenticator() {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return authenticator;
    }

    protected Long getGlobalSessionOut() {
        return AbstractSessionManager.DEFAULT_GLOBAL_SESSION_TIMEOUT * 4;
    }

    /**
     * shiro生命周期
     */
    @Bean("lifecycleBeanPostProcessor")
    protected LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean("advisorAutoProxyCreator")
    protected DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
     */
    @Bean("authorizationAttributeSourceAdvisor")
    @DependsOn({"securityManager"})
    protected AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码; ）
     *
     * @return
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(MD5);
        hashedCredentialsMatcher.setHashIterations(entryTimes);
        return hashedCredentialsMatcher;
    }
}

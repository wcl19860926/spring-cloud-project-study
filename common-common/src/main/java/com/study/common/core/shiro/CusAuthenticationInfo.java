package com.study.common.core.shiro;

import lombok.Data;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xiquee.com. <br>
 * @date 2018-11-09 10:16:00
 */
@Data
public class CusAuthenticationInfo extends SimpleAuthenticationInfo {

    private int userType;
    private String userId;
    private String username;
    private Map<String, Object> properties = new HashMap<>();

    public CusAuthenticationInfo(int userType, String userId, String username, String password, ByteSource credentialsSalt, String realmName) {
        super(username, password, credentialsSalt, realmName);
        this.userType = userType;
        this.userId = userId;
        this.username = username;
    }

    /**
     *
     * @param pros
     */
    public void setProperties(Map<String, Object> pros) {
        if (pros != null && pros.size() > 0) {
            this.properties.putAll(pros);
        }
    }
    public void setProperty(String key, Object value) {
        this.getProperties().put(key,value);
    }
}

package com.study.user.security.shiro.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
    prefix = "shiro.login"
)
@Data
public class ShiroProperties {
    private int pageSize;
    private boolean vcodeForTest;
    private int loginAttemptTimes;
    private int loginAttemptSpan;
    private int leftTimesForErrPswd;

    public ShiroProperties() {
    }


    public String toString() {
        return "SystemSettings(pageSize=" + this.getPageSize() + ", vcodeForTest=" + this.isVcodeForTest() + ", loginAttemptTimes=" + this.getLoginAttemptTimes() + ", loginAttemptSpan=" + this.getLoginAttemptSpan() + ", leftTimesForErrPswd=" + this.getLeftTimesForErrPswd() + ")";
    }
}

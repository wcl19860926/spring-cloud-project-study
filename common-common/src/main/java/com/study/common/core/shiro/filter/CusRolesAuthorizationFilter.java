package com.study.common.core.shiro.filter;

import com.study.common.base.error.codes.ErrorCodes;
import com.study.common.core.exception.BizException;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author : zhaoxuan
 * @date : 2019/12/4
 */
public class CusRolesAuthorizationFilter extends RolesAuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        if (super.isAccessAllowed(request, response, mappedValue)) {
            throw new BizException(ErrorCodes.SYS_ERROR_403);
        }
        return true;
    }
}

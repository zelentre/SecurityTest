package com.zne.handle;

import com.zne.core.domain.BaseResult;
import com.zne.util.JacksonUtil;
import com.zne.util.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZNE
 * @since 2022/10/31
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // 处理异常
        BaseResult baseResult = new BaseResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败请重新登录");
        WebUtil.renderString(response, JacksonUtil.toJson(baseResult));
    }
}

package com.zne.handle;

import com.zne.core.domain.BaseResult;
import com.zne.util.JacksonUtil;
import com.zne.util.WebUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 处理异常
        BaseResult baseResult = new BaseResult(HttpStatus.FORBIDDEN.value(), "您的权限不足");
        WebUtil.renderString(response, JacksonUtil.toJson(baseResult));
    }
}

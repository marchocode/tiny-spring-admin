package com.github.marchocode.security.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // org.springframework.security.authentication.BadCredentialsException: Bad credentials 用户名错误

        String message = "用户名或密码错误";

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        response.setContentLength(message.getBytes().length);

        response.getWriter().print(message);
        response.getWriter().flush();
    }
}

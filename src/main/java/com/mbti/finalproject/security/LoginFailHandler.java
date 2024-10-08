package com.mbti.finalproject.security;

import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
//AuthenticationFailureHandler : 로그인 실패 후 처리할 작업를 해야 할 때 사용하는  인터페이스입니다.
public class LoginFailHandler implements AuthenticationFailureHandler {
    private static final Logger log = LoggerFactory.getLogger(LoginFailHandler.class);

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        log.info(exception.getMessage());
        log.info("로그인 실패");

        request.getSession().setAttribute("fail", "loginFailMsg");
        String url = request.getContextPath() + "/user/login";
        response.sendRedirect(url);


    }
}

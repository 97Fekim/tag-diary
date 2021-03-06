package com.fekim.tagdiary.security.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

        log.info("===========logout===========");

        /* 비정상 로그아웃 */
        if(authentication != null && authentication.getDetails() != null){
            try{
                request.getSession().invalidate();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        /* 정상 로그아웃 */
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");
    }
}

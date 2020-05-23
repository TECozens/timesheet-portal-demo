package com.admiral.tsp.timesheetportal.security.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_CONTRACTOR")) {
            httpServletResponse.sendRedirect("/contractorView");
        } else if (roles.contains("ROLE_MANAGER")) {
            httpServletResponse.sendRedirect("/Reviews");
        } else if (roles.contains("ROLE_ADMIN")){
            httpServletResponse.sendRedirect("/Invoices");
        } else {
            httpServletResponse.sendRedirect("/403");
        }
    }

}

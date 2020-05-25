package com.admiral.tsp.timesheetportal.security.services;

import com.admiral.tsp.timesheetportal.security.data.MyUserPrincipal;
import com.admiral.tsp.timesheetportal.data.jpa.UserJpa;
import com.admiral.tsp.timesheetportal.data.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserJpa userJpa;
    private final PasswordEncoder encoder;
    private final LoginAttemptService loginAttemptService;
    private final HttpServletRequest request;

    @Autowired
    public MyUserDetailsService(UserJpa userJpa, PasswordEncoder encoder, LoginAttemptService loginAttemptService, HttpServletRequest request) {
        this.userJpa = userJpa;
        this.encoder = encoder;
        this.loginAttemptService = loginAttemptService;
        this.request = request;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        log.info("password encoded = " + encoder.encode("password"));

        String ip = getClientIP();
        User user = userJpa.getByUsername(username);
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("blocked");
        }


        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            log.info("User = " + user);

            List<String> userRoles = userJpa.findRoleByUsername(username);
            return new MyUserPrincipal(user, userRoles);
        }
    }

    private String getClientIP() {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}

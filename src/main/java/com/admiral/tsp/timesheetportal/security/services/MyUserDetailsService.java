package com.admiral.tsp.timesheetportal.security.services;

import com.admiral.tsp.timesheetportal.security.data.MyUserPrincipal;
import com.admiral.tsp.timesheetportal.data.jpa.UserJpa;
import com.admiral.tsp.timesheetportal.data.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserJpa userJpa;
    private final PasswordEncoder encoder;

    @Autowired
    public MyUserDetailsService(UserJpa userJpa, PasswordEncoder encoder) {
        this.userJpa = userJpa;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        log.info("password encoded = " + encoder.encode("password"));


        User user = userJpa.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            log.info("User = " + user);

            List<String> userRoles = userJpa.findRoleByUsername(username);
            return new MyUserPrincipal(user, userRoles);
        }
    }

//    public User registerNewUserAccount(UserForm userForm) {
//
//        User newUser = new User(null, userForm.getUsername(),
//                userForm.getFirstName(),
//                userForm.getSurname(),
//                userForm.getEmail(),
//                userForm.getPassword());
//
//
//        return newUser;
//
//    }

}

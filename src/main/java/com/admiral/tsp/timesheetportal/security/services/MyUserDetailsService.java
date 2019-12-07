package com.admiral.tsp.timesheetportal.security.services;

import com.admiral.tsp.timesheetportal.security.data.domain.MyUserPrincipal;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
import com.admiral.tsp.timesheetportal.security.services.UserRolesRepository;
import com.admiral.tsp.timesheetportal.security.data.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) {

        System.out.println("password encoded = " + encoder.encode("password"));


        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            System.out.println("User = " + user);

            List<String> userRoles = userRolesRepository.findRoleByUsername(username);
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

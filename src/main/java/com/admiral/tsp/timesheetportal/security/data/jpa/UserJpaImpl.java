package com.admiral.tsp.timesheetportal.security.data.jpa;

import com.admiral.tsp.timesheetportal.security.data.domain.User;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserJpaImpl implements UserJpa{
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}

package com.admiral.tsp.timesheetportal.data;

import com.admiral.tsp.timesheetportal.csrf.User;
import com.admiral.tsp.timesheetportal.csrf.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserJpaImpl implements UserJpa{
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}

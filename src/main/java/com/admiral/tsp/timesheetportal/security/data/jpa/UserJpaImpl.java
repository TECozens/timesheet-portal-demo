package com.admiral.tsp.timesheetportal.security.data.jpa;

import com.admiral.tsp.timesheetportal.security.data.domain.User;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserJpaImpl implements UserJpa{
    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> findManagers() {
        return userRepository.findByManagerRole();
    }

    @Override
    public List<User> findContractors() {
        return userRepository.findByContractorRole();
    }
}

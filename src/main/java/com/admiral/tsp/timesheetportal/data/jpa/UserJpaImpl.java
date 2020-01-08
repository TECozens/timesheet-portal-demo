package com.admiral.tsp.timesheetportal.data.jpa;

import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.domain.UserRole;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
import com.admiral.tsp.timesheetportal.security.services.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserJpaImpl implements UserJpa{

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserJpaImpl(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    @Transactional
    public User makeUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public User getEmailByUsername(String username) {
        return userRepository.getEmailByUsername(username);
    }

    @Override
    public List<User> findManagers() {
        return userRepository.findByManagerRole();
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findUsers();
    }

    @Override
    public List<User> findContractors() {
        return userRepository.findByContractorRole();
    }

    @Override
    public List<User> findAdmins(){return userRepository.findByAdminRole();
    }


    @Override
    @Transactional
    public UserRole makeUserRole(UserRole userRole) {
        return userRolesRepository.saveAndFlush(userRole);
    }

    @Override
    public List<String> findRoleByUsername(String username) {
        return userRolesRepository.findRoleByUsername(username);
    }

    @Override
    @Transactional
    public void updatePassword(Long id, String password) {
        userRepository.updatePassword(id, password);
    }

}

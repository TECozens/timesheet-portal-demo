package com.admiral.tsp.timesheetportal.data.jpa;

import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.domain.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserJpa {

    User makeUser(User user);

    User getById(Long id);

    User getByUsername(String username);

    User getEmailByUsername(String username);

    List<User> findManagers();

    List<User> findUsers();

    List<User> findContractors();

    List<User>findAdmins();

    UserRole makeUserRole(UserRole userRole);

    List<String> findRoleByUsername(String username);

    void updatePassword(Long id, String password);

}

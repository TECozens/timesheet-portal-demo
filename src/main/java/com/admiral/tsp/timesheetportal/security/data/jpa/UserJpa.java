package com.admiral.tsp.timesheetportal.security.data.jpa;

import com.admiral.tsp.timesheetportal.security.data.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserJpa {

    User getById(Long id);

    User getByUsername(String username);

    public List<User> findManagers();
    public List<User> findContractors();
}

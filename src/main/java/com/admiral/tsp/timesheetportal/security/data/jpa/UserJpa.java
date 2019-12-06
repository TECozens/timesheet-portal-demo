package com.admiral.tsp.timesheetportal.security.data.jpa;

import com.admiral.tsp.timesheetportal.security.data.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpa {

    User getUserById(Long id);
}

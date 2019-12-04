package com.admiral.tsp.timesheetportal.data;

import com.admiral.tsp.timesheetportal.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpa {

    User getUserById(Long id);
}

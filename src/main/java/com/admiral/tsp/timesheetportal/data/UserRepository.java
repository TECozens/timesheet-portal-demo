package com.admiral.tsp.timesheetportal.data;

import com.admiral.tsp.timesheetportal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

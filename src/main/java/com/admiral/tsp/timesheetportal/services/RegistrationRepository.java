package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.security.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Long> {
}

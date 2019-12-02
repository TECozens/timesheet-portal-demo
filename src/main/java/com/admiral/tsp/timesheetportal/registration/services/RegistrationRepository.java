package com.admiral.tsp.timesheetportal.registration.services;

import com.admiral.tsp.timesheetportal.csrf.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Long> {
}

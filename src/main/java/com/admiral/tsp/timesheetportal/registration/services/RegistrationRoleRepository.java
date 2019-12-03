package com.admiral.tsp.timesheetportal.registration.services;

import com.admiral.tsp.timesheetportal.csrf.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRoleRepository extends JpaRepository<UserRole, Long> {
}

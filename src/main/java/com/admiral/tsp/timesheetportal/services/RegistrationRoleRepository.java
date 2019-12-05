package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.security.data.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRoleRepository extends JpaRepository<UserRole, Long> {
}

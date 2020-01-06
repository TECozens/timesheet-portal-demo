package com.admiral.tsp.timesheetportal.security.services;

import com.admiral.tsp.timesheetportal.data.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRole, Long> {

    @Query("select a.role from UserRole a, User b where b.username=?1 and a.userid=b.id")
    List<String> findRoleByUsername(String username);

    @Query("select a from UserRole a where a.role = 'ROLE_MANAGER'")
    List<String> findByManagerRole(String manager);

    @Query("select a from UserRole a where a.role = 'ROLE_ADMIN'")
    List<String> findByAdminRole(String admin);


}

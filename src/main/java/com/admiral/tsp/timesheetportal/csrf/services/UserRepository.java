package com.admiral.tsp.timesheetportal.csrf.services;

import com.admiral.tsp.timesheetportal.csrf.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id =:id")
    User getUserById(@Param("id") Integer id);
    @Query("SELECT u FROM User u WHERE u.username =:username")
    User getUserByUsername(@Param("username") String username);
}

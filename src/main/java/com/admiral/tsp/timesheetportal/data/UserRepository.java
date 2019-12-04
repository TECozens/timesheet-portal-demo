package com.admiral.tsp.timesheetportal.data;

import com.admiral.tsp.timesheetportal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id =:id")
    User getUserById(@Param("id") Long id);
    @Query("SELECT u FROM User u WHERE u.username =:username")
    User getUserByUsername(@Param("username") String username);
    @Query("select u from User u, UserRole a where a.role = 'ROLE_MANAGER' AND u.id = a.userid")
    public List<User> findByManagerRole();
    @Query("SELECT u FROM User u, UserRole a WHERE a.role = 'ROLE_CONTRACTOR' AND u.id = a.userid")
    public List<User> findByContractorRole();
}

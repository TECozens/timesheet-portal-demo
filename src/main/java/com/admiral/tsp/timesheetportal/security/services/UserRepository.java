package com.admiral.tsp.timesheetportal.security.services;

import com.admiral.tsp.timesheetportal.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE u.id =:id")
    User getUserById(@Param("id") Long id);
    @Query("SELECT u FROM User u WHERE u.username =:username")
    User getUserByUsername(@Param("username") String username);
    @Query("SELECT u FROM User u WHERE u.username =:username")
    User getEmailByUsername(@Param("username") String username);
    @Query("select u from User u, UserRole a where a.role = 'ROLE_MANAGER' AND u.id = a.userid")
    List<User> findByManagerRole();
    @Query("select u from User u")
    List<User> findUsers();
    @Query("SELECT u FROM User u, UserRole a WHERE a.role = 'ROLE_CONTRACTOR' AND u.id = a.userid")
    List<User> findByContractorRole();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.password = :password WHERE u.id = :id")
    void updatePassword(@Param("id") Long id, @Param("password") String password);
    @Query("SELECT u FROM User u, UserRole a WHERE a.role = 'ROLE_ADMIN' AND u.id = a.userid")
    List<User> findByAdminRole();

}

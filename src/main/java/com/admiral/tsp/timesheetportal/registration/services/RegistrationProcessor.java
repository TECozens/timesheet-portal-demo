package com.admiral.tsp.timesheetportal.registration.services;

import com.admiral.tsp.timesheetportal.domain.User;
import com.admiral.tsp.timesheetportal.domain.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RegistrationProcessor implements RegistrationJpaRepo {

    private JpaRepository<User, Long> repoJpa;

    @Autowired
    public RegistrationProcessor(JpaRepository<User, Long> aJPARepo){
        repoJpa = aJPARepo;
    }

    @Override
    @Transactional
    public User makeUser(User newUser) {
        User update = repoJpa.saveAndFlush(newUser);

        return update;
    }

//    @Override
//    @Transactional
//    public UserRole makeRole(UserRole newRole) {
//        UserRole update =
//    }

}

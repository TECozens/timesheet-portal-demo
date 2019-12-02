package com.admiral.tsp.timesheetportal.registration.services;

import com.admiral.tsp.timesheetportal.csrf.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RegistrationJpaImpl implements RegistrationJpa {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    @Transactional
    public User makeUser(User newUser) {

        User update = registrationRepository.saveAndFlush(newUser);

        log.info(update.toString());

        return update;
    }

//    @Override
//    @Transactional
//    public UserRole makeRole(UserRole newRole) {
//        UserRole update =
//    }

}

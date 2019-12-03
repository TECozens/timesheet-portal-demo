package com.admiral.tsp.timesheetportal.registration.services;

import com.admiral.tsp.timesheetportal.agency.Agency;
import com.admiral.tsp.timesheetportal.agency.services.AgencyRepository;
import com.admiral.tsp.timesheetportal.csrf.User;
import com.admiral.tsp.timesheetportal.csrf.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RegistrationJpaImpl implements RegistrationJpa {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationRoleRepository registrationRoleRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    @Transactional
    public User makeUser(User newUser) {

        User update = registrationRepository.saveAndFlush(newUser);

        log.info(update.toString());

        return update;
    }

    @Override
    @Transactional
    public UserRole makeRole(UserRole newRole) {
        UserRole update = registrationRoleRepository.saveAndFlush(newRole);

        return update;
    }

    @Override
    @Transactional
    public Agency makeAgency(Agency newAgency) {
        Agency update = agencyRepository.saveAndFlush(newAgency);

        return update;
    }

}

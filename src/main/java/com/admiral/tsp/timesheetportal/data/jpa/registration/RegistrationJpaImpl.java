package com.admiral.tsp.timesheetportal.data.jpa.registration;

import com.admiral.tsp.timesheetportal.data.domain.Agency;
import com.admiral.tsp.timesheetportal.services.AgencyRepository;
import com.admiral.tsp.timesheetportal.services.RegistrationRepository;
import com.admiral.tsp.timesheetportal.services.RegistrationRoleRepository;
import com.admiral.tsp.timesheetportal.security.data.domain.User;
import com.admiral.tsp.timesheetportal.security.data.domain.UserRole;
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

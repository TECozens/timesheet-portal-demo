package com.admiral.tsp.timesheetportal.registration.services;

import com.admiral.tsp.timesheetportal.domain.User;
import com.admiral.tsp.timesheetportal.domain.UserRole;

public interface RegistrationJpaRepo {

    User makeUser (User userReg);

//    UserRole makeRole (UserRole roleReg);

}

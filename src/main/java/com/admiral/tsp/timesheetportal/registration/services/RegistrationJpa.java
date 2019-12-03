package com.admiral.tsp.timesheetportal.registration.services;

import com.admiral.tsp.timesheetportal.csrf.User;
import com.admiral.tsp.timesheetportal.csrf.UserRole;

public interface RegistrationJpa {

    User makeUser (User userReg);

    UserRole makeRole (UserRole roleReg);

}

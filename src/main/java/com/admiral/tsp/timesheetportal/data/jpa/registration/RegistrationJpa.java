package com.admiral.tsp.timesheetportal.data.jpa.registration;

import com.admiral.tsp.timesheetportal.data.domain.Agency;
import com.admiral.tsp.timesheetportal.security.data.domain.User;
import com.admiral.tsp.timesheetportal.security.data.domain.UserRole;

public interface RegistrationJpa {

    User makeUser (User userReg);

    UserRole makeRole (UserRole roleReg);

    Agency makeAgency (Agency agencyReg);

}

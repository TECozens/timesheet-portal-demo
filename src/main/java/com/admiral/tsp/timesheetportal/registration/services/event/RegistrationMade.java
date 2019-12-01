package com.admiral.tsp.timesheetportal.registration.services.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationMade {

    private String username;

    private String firstname;

    private String surname;

    private String email;

    private String password;

    private String role;


}

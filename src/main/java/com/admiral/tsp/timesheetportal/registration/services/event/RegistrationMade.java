package com.admiral.tsp.timesheetportal.registration.services.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationMade {

    private String username;

    private String firstName;

    private String surname;

    private String email;

    private String password;

    private String role;


}

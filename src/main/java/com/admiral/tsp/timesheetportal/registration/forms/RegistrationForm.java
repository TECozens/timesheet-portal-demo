package com.admiral.tsp.timesheetportal.registration.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

    @NotNull(message = "Must have a username")
    private String username;

    @NotNull(message = "Must have a first name")
    private String firstname;

    @NotNull(message = "Must have a surname")
    private String surname;

    @Email
    @NotNull(message = "Must have an email")
    private String email;

    @Min(value = 8, message = "Password must be at least 8 characters or more!")
    @NotNull(message = "Must have a password")
    private String password;

    @NotNull(message = "Must have a role")
    private String role;

    private Long agencyId;

    private Long managerId;

}

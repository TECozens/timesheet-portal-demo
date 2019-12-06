package com.admiral.tsp.timesheetportal.web.forms.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {

    @NotNull(message = "Must have a username")
    @NotBlank(message = "Must have a username")
    private String username;

    @NotNull(message = "Must have a first name")
    @NotBlank(message = "Must have a first name")
    private String firstname;

    @NotNull(message = "Must have a surname")
    @NotBlank(message = "Must have a surname")
    private String surname;

    @Email(message = "Needs to be an email!")
    @NotNull(message = "Must have an email")
    @NotBlank(message = "Must have an email")
    private String email;

    @NotNull(message = "Must have a password")
    @NotBlank(message = "Must have a password")
    @Size(min = 8, message = "A password must be at least 8 characters or more!")
    private String password;

    @NotNull(message = "Must have a role")
    private String role;

    private Long agencyId;

    private Long managerId;

}

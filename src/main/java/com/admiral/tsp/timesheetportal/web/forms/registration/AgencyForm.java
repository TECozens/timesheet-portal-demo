package com.admiral.tsp.timesheetportal.web.forms.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyForm {

    @NotNull(message = "Must have an Agency name!")
    @NotBlank(message = "Must have an Agency name!")
    private String name;

    @Email(message = "Needs to be an email!")
    @NotNull(message = "Must have an email!")
    @NotBlank(message = "Must have an email!")
    private String email;

}

package com.admiral.tsp.timesheetportal.registration.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyForm {

    @NotNull(message = "Must have a username")
    private String name;

    @NotNull(message = "Must have a first name")
    private String email;

}

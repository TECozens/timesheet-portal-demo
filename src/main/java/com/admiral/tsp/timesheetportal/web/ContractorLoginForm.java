package com.admiral.tsp.timesheetportal.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractorLoginForm {

    @NotNull
    @Size(min = 2, max = 50, message = "Invalid Name")
    private String name;

    @NotNull
    @Size(min = 1, message = "Please enter a password")
    private String Password;

}

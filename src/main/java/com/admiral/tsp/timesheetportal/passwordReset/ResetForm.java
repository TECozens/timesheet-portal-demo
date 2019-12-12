package com.admiral.tsp.timesheetportal.passwordReset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetForm {

    @NotNull(message = "Must have a username")
    @NotBlank(message = "Must have a username")
    private String username;

    @NotNull(message = "Must have a password")
    @NotBlank(message = "Must have a password")
    @Size(min = 8, message = "A password must be at least 8 characters or more!")
    private String password;

}

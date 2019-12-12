package com.admiral.tsp.timesheetportal.web.forms.passwordreset;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetForm {

    @NotNull(message = "Must have a username")
    @NotBlank(message = "Must have a username")
    private String username;

}

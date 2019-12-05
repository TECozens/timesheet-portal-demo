package com.admiral.tsp.timesheetportal.web.forms.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetIdPassForm {

    @NotNull
    private Long timesheet_ID;

}
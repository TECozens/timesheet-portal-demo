package com.admiral.tsp.timesheetportal.timesheet.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetForm {

    @NotNull
    private Integer days_worked;

    private Integer overtime_completed;
}

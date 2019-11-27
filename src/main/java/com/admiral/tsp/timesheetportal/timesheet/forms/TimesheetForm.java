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
    @Size(min = 2, max = 50, message = "Invalid Name")
    private String name;

//    @NotNull
//    @Size(min = 2, max = 50, message = "Invalid Manager Name")
//    private String managerName;

    @NotNull
    @Size(min = 2, max = 50, message = "Invalid Agency")
    private String agency;

    @NotNull
    private Integer days_worked;

    @NotNull
    private Integer overtime_completed;

//    @NotNull
//    @Size(min = 2, max = 50, message = "Invalid Overtime Reason")
//    private String otReason;

//    @NotNull
//    private Integer expenses;

//    @NotNull
//    private Boolean approved;

}

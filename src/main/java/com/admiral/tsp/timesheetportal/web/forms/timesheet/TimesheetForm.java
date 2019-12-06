package com.admiral.tsp.timesheetportal.web.forms.timesheet;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetForm {

    @NotNull(message = "Must not be empty!")
    @Max(value = 7, message = "Must be 5 days or less")
    @Min(value = 1, message = "You must work at least 1 day!")
    private Integer days_worked;

    private Integer overtime_completed;
}

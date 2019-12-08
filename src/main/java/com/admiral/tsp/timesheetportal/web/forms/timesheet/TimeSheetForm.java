package com.admiral.tsp.timesheetportal.web.forms.timesheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSheetForm {

    @NotNull(message = "Must not be empty!")
    @Max(value = 7, message = "Must be 7 days or less")
    @Min(value = 1, message = "You must work at least 1 day!")
    private Integer days_worked;

    private Integer overtime_completed;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate week_ending;
}

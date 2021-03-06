package com.admiral.tsp.timesheetportal.web.forms.review;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalReviewForm {

    private TimeSheet timesheet;
    private Boolean approved;
    private Boolean paid;
    private String message;
    @NotNull(message = "Must not be empty!")
    @Max(value = 3, message = "You must choose a number between 1 and 3!")
    @Min(value = 1, message = "You must choose a number between 1 and 3!")
    private Integer communication;
    @NotNull(message = "Must not be empty!")
    @Max(value = 3, message = "You must choose a number between 1 and 3!")
    @Min(value = 1, message = "You must choose a number between 1 and 3!")
    private Integer technical_skills;
    @NotNull(message = "Must not be empty!")
    @Max(value = 3, message = "You must choose a number between 1 and 3!")
    @Min(value = 1, message = "You must choose a number between 1 and 3!")
    private Integer quality;
    @NotNull(message = "Must not be empty!")
    @Max(value = 3, message = "You must choose a number between 1 and 3!")
    @Min(value = 1, message = "You must choose a number between 1 and 3!")
    private Integer initiative;
    @NotNull(message = "Must not be empty!")
    @Max(value = 3, message = "You must choose a number between 1 and 3!")
    @Min(value = 1, message = "You must choose a number between 1 and 3!")
    private Integer productivity;
    @NotNull(message = "Must not be empty!")
    @Max(value = 3, message = "You must choose a number between 1 and 3!")
    @Min(value = 1, message = "You must choose a number between 1 and 3!")
    private Integer working_relationships;


}

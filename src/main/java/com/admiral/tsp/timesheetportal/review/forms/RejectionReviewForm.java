package com.admiral.tsp.timesheetportal.review.forms;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RejectionReviewForm {

    private Timesheet timesheet;
    private Boolean approved;
    private Boolean paid;
    @NotNull(message = "Must not be empty!")
    private  String message;
    private Integer communication;
    private Integer technical_skills;
    private Integer quality;
    private Integer initative;
    private Integer productivity;
    private Integer working_relationships;



}

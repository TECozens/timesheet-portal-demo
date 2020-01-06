package com.admiral.tsp.timesheetportal.web.forms.review;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RejectionReviewForm {

    private TimeSheet timesheet;
    private Boolean approved;
    private Boolean paid;
    @NotNull(message = "Must not be empty! Why was this rejected?")
    @NotBlank(message = "Must not be empty! Why was this rejected?")
    private String message;
    private Integer communication;
    private Integer technical_skills;
    private Integer quality;
    private Integer initative;
    private Integer productivity;
    private Integer working_relationships;



}

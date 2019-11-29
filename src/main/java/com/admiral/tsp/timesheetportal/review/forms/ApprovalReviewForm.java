package com.admiral.tsp.timesheetportal.review.forms;

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
    private Integer initative;
    @NotNull(message = "Must not be empty!")
    @Max(value = 3, message = "You must choose a number between 1 and 3!")
    @Min(value = 1, message = "You must choose a number between 1 and 3!")
    private Integer working_relations;


    private String message;
}

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
public class RejectionReviewForm {

    @NotNull(message = "Must not be empty!")
    private  String message;


}

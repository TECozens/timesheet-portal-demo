package com.admiral.tsp.timesheetportal.timesheet.controllers;

import com.admiral.tsp.timesheetportal.review.Review;
import com.admiral.tsp.timesheetportal.review.services.ReviewJpa;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/timesheets")
public class TimesheetRestController {

    @Autowired
    private ReviewJpa reviewJpa;
    @Autowired
    private TimesheetJpa timesheetJpa;



    @PostMapping("/approve/{id}")
    public ResponseEntity approveTimesheet(@PathVariable("id") Integer id) {

        // Approve by the given id here

        Timesheet timesheet = timesheetJpa.getByID(id).get();
        Boolean approved = true;

        Review review = new Review(
                null,
                timesheet,
                approved,
                "",
                3,
                3,
                3,
                3,
                3,
                3);

        review = reviewJpa.makeReview(review);

        log.info(review.toString());



        return ResponseEntity.ok().build();
    }
}

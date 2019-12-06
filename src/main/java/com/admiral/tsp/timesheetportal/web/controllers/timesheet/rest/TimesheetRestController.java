package com.admiral.tsp.timesheetportal.web.controllers.timesheet.rest;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.data.jpa.review.ReviewJpa;
import com.admiral.tsp.timesheetportal.data.domain.Timesheet;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimesheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/timesheets/")
public class TimesheetRestController {

    @Autowired
    private ReviewJpa reviewJpa;
    @Autowired
    private TimesheetJpa timesheetJpa;



    @PostMapping("/review/approve/{id}")
    public ResponseEntity approveTimesheet(@PathVariable("id") Long id) {

        // Approve by the given id here

        Timesheet timesheet = timesheetJpa.getByID(id).get();
        Boolean approved = true;

        Review review = new Review(
                null,
                timesheet,
                approved,
                false,
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

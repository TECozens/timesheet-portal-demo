package com.admiral.tsp.timesheetportal.timesheet.controllers;

import com.admiral.tsp.timesheetportal.review.Review;
import com.admiral.tsp.timesheetportal.review.services.ReviewJpaRepo;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/timesheets")
public class TimesheetRestController {

    @Autowired
    private ReviewJpaRepo reviewJpaRepo;
    @Autowired
    private TimesheetJpaRepo timesheetJpaRepo;



    @PostMapping("/approve/{id}")
    public ResponseEntity approveTimesheet(@PathVariable("id") Integer id) {

        // Approve by the given id here

        Timesheet timesheet = timesheetJpaRepo.getByID(id).get();
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

        review = reviewJpaRepo.makeReview(review);

        log.info(review.toString());



        return ResponseEntity.ok().build();
    }
}

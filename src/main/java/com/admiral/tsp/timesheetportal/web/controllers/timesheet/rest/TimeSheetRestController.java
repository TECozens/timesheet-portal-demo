package com.admiral.tsp.timesheetportal.web.controllers.timesheet.rest;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.data.jpa.ReviewJpa;
import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.data.jpa.TimeSheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/timeSheets/")
public class TimeSheetRestController {

    private final ReviewJpa reviewJpa;
    private final TimeSheetJpa timesheetJpa;

    @Autowired
    public TimeSheetRestController(ReviewJpa reviewJpa, TimeSheetJpa timesheetJpa) {
        this.reviewJpa = reviewJpa;
        this.timesheetJpa = timesheetJpa;
    }


    @PostMapping("/review/approve/{id}")
    public ResponseEntity approveTimeSheet(@PathVariable("id") Long id) {

        // Approve by the given id here

        TimeSheet timesheet = timesheetJpa.getByID(id).get();
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

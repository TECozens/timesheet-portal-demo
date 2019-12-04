package com.admiral.tsp.timesheetportal.review.controllers;

import com.admiral.tsp.timesheetportal.review.Review;
import com.admiral.tsp.timesheetportal.review.services.ReviewJpa;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ReviewRestController {

    @Autowired
    private ReviewJpa reviewJpa;



    @GetMapping(path = "/api/reviews/confirm/{id}")
    public ResponseEntity<Object> confirmInvoice(@PathVariable("id") Integer id) {

        // Approve by the given id here
        reviewJpa.updatePaid(id,true);
        Review updated = reviewJpa.getByID(id).get();


        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

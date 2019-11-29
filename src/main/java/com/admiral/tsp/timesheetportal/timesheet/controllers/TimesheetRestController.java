package com.admiral.tsp.timesheetportal.timesheet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/timesheets/")
public class TimesheetRestController {



    @PostMapping("/review/approve/{id}")
    public ResponseEntity approveTimesheet(@PathVariable("id") Integer id) {

        // Approve by the given id here

        return ResponseEntity.ok().build();
    }
}

package com.admiral.tsp.timesheetportal.services;


import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.finder.TimesheetFinder;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimesheetQueries implements TimesheetFinder {

    private TimesheetRepo timesheetRepository;

    public Optional<Timesheet> findTimesheetByIndex (Integer index){

        return timesheetRepository.findById(index.longValue());
    }



}

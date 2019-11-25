package com.admiral.tsp.timesheetportal.services;


import com.admiral.tsp.timesheetportal.data.TimesheetRepoJPA;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.finder.TimesheetFinder;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimesheetQueries implements TimesheetFinder {

    private TimesheetRepoJPA timesheetRepository;


    public TimesheetQueries(TimesheetRepoJPA aTRepo) {
        timesheetRepository = aTRepo;

    }

    public Optional<Timesheet> getFindTimesheetByIndex (Integer index){
        return timesheetRepository.findById(index.longValue());
    }

}

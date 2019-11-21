package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.data.TimesheetRepoJPA;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TimesheetServiceImpl implements TimesheetService {

    private TimesheetRepoJPA timesheetRepoJPA;

    @Autowired
    public TimesheetServiceImpl(TimesheetRepoJPA aTJPARepo) {
        timesheetRepoJPA = aTJPARepo;
    }

    @Override
    public List<Timesheet> findByContractor(Contractor contractor) {
        return timesheetRepoJPA.findByContractor(contractor);
    }
}

package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.data.TimesheetRepoJPA;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import com.admiral.tsp.timesheetportal.services.event.TimesheetMade;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TimesheetProcessor implements TimesheetCreator {

    static final Logger LOG = LoggerFactory.getLogger(TimesheetProcessor.class);

    private TimesheetRepo timesheetRepo;
    private TimesheetRepoJPA timesheetRepoJPA;

    @Autowired
    public TimesheetProcessor(TimesheetRepo aTRepo, TimesheetRepoJPA aTJPARepo) {
        timesheetRepo = aTRepo;
        timesheetRepoJPA = aTJPARepo;
    }


    @Override
    @Transactional
    public void makeTimesheet(Timesheet newTimesheet) {
        timesheetRepoJPA.save(newTimesheet);
    }
}

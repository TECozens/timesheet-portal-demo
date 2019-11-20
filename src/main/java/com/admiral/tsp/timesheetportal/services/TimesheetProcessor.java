package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import com.admiral.tsp.timesheetportal.services.event.TimesheetMade;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TimesheetProcessor implements TimesheetCreator {

    static final Logger LOG = LoggerFactory.getLogger(TimesheetProcessor.class);

    private TimesheetRepo timesheetRepo;

    @Autowired
    public TimesheetProcessor(TimesheetRepo aTRepo) {
        timesheetRepo = aTRepo;
    }


    @Override
    public void makeTimesheet(TimesheetMade newTimesheet) {
        timesheetRepo.saveTimesheetToDB(newTimesheet);
    }
}

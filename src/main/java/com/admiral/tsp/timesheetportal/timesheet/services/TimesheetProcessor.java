package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
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

    private TimesheetRepoJPA timesheetRepoJPA;

    @Autowired
    public TimesheetProcessor(TimesheetRepoJPA aTJPARepo) {
        timesheetRepoJPA = aTJPARepo;
    }


    @Override
    @Transactional
    public void makeTimesheet(Timesheet newTimesheet) {
        log.info(String.valueOf(timesheetRepoJPA.saveAndFlush(newTimesheet).getId()));
        log.info(newTimesheet.toString());
    }
}

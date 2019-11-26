package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TimesheetProcessor implements TimesheetCreator {

    private TimesheetRepoJPA timesheetRepoJPA;

    @Autowired
    public TimesheetProcessor(TimesheetRepoJPA aTJPARepo) {
        timesheetRepoJPA = aTJPARepo;
    }


    @Override
    @Transactional
    public Timesheet makeTimesheet(Timesheet newTimesheet) {
        Timesheet updatedTimesheet = timesheetRepoJPA.saveAndFlush(newTimesheet);
        log.info(newTimesheet.toString());
        return updatedTimesheet;
    }
}

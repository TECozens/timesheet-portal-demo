package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Timesheet> getTimesheetByIndex(Long index) {
        return timesheetRepoJPA.findById(index);
    }

    @Override
    public List<Timesheet> getAll() {
        return timesheetRepoJPA.findAll();
    }

}

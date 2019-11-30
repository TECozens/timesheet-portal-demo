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
public class TimesheetJpaImpl implements TimesheetJpa {

    // Autowired the timesheet repository inside implementation
    @Autowired
    private TimesheetRepository timesheetRepository;



    @Override
    @Transactional
    public Timesheet makeTimesheet(Timesheet newT) {

        Timesheet updated = timesheetRepository.saveAndFlush(newT);

        log.info(updated.toString());

        return updated;
    }

    @Override
    public Optional<Timesheet> getByID(Integer id) {
        return timesheetRepository.getTimesheetById(id);
    }

    @Override
    public List<Timesheet> getAll() {
        return timesheetRepository.getAllTimesheets();
    }

}

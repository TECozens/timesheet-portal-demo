package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TimesheetProcessor implements TimesheetJpaRepo {

    // Autowired the generic referenced JPA repository inside the implemented Repo
    // This cleans up the layout of the code and bundles together the JPA interfaces
    @Autowired
    private TimesheetRepository timesheetRepository;



    @Override
    @Transactional
    public Timesheet makeTimesheet(Timesheet newT) {
        log.info("lookhere");
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

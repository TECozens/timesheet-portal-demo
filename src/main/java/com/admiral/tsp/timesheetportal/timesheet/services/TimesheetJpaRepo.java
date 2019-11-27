package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Implemented by TimesheetProcessor
public interface TimesheetJpaRepo {

    Timesheet makeTimesheet(Timesheet item);
    Optional<Timesheet> getByID(Long index);
    List<Timesheet> getAll();

}

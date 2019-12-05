package com.admiral.tsp.timesheetportal.data.jpa.timesheet;

import com.admiral.tsp.timesheetportal.data.domain.Timesheet;

import java.util.List;
import java.util.Optional;

// Implemented by TimesheetJpaImpl
public interface TimesheetJpa {

    Timesheet makeTimesheet(Timesheet item);
    Optional<Timesheet> getByID(Long index);
    List<Timesheet> getAll();

}

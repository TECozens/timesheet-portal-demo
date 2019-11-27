package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;

import java.util.List;
import java.util.Optional;

// Implemented by TimesheetProcessor
public interface TimesheetCreator {
    Timesheet makeTimesheet(Timesheet timesheetEvent);
    Optional<Timesheet> getByID(Long index);
    List<Timesheet> getAll();
}

package com.admiral.tsp.timesheetportal.finder;

import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;

import java.util.List;
import java.util.Optional;

public interface TimesheetFinder {
    Optional<Timesheet> getFindTimesheetByIndex(Integer index);
    List<Timesheet> getAll();
}

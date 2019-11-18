package com.admiral.tsp.timesheetportal.finder;

import com.admiral.tsp.timesheetportal.domain.Timesheet;

import java.util.List;
import java.util.Optional;

public interface TimesheetFinder {
    public Optional<Timesheet> findTimesheetByIndex(Integer index);

}

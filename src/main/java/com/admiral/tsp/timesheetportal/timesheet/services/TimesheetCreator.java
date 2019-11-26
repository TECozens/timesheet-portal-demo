package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;

// Implemented by TimesheetProcessor
public interface TimesheetCreator {
    Timesheet makeTimesheet(Timesheet timesheetEvent);
}

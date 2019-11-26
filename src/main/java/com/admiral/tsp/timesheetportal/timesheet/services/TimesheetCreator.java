package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;

// Implemented by ReviewProcessor
public interface TimesheetCreator {
    Timesheet makeTimesheet(Timesheet timesheetEvent);
}

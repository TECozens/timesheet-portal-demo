package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.services.event.TimesheetMade;

public interface TimesheetCreator {
    void makeTimesheet(TimesheetMade timesheetEvent);
}

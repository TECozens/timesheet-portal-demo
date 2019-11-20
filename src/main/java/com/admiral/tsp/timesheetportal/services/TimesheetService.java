package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;

import java.util.List;

public interface TimesheetService {
    List<Timesheet> findByContractor(Contractor contractor);
}

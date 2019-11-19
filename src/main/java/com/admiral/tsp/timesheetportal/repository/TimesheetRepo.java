package com.admiral.tsp.timesheetportal.repository;

import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.services.event.TimesheetMade;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TimesheetRepo {

    void saveTimesheetToDB(TimesheetMade timesheetInstance);

    Optional<Timesheet> findById(Long id);
}

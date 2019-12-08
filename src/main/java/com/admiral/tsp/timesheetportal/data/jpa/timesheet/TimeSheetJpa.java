package com.admiral.tsp.timesheetportal.data.jpa.timesheet;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;

import java.util.List;
import java.util.Optional;

// Implemented by TimeSheetJpaImpl
public interface TimeSheetJpa {

    TimeSheet makeTimeSheet(TimeSheet item);
    Optional<TimeSheet> getByID(Long index);
    List<TimeSheet> getAll();

}

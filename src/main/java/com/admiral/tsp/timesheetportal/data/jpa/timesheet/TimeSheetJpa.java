package com.admiral.tsp.timesheetportal.data.jpa.timesheet;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.data.domain.User;

import java.util.List;
import java.util.Optional;

// Implemented by TimeSheetJpaImpl
public interface TimeSheetJpa {

    TimeSheet makeTimeSheet(TimeSheet item);
    Optional<TimeSheet> getByID(Long index);
    List<TimeSheet> getAll();
    List<TimeSheet> getUnreviewed();
    List<TimeSheet> getByManager(User manager);
    List<TimeSheet> getUnreviewedByManager(User manager);

}

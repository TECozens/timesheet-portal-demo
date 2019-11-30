package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Implemented by TimesheetJpaImpl
public interface TimesheetJpa {

    Timesheet makeTimesheet(Timesheet item);
    Optional<Timesheet> getByID(Integer index);
    List<Timesheet> getAll();

}

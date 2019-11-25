package com.admiral.tsp.timesheetportal.Timesheet.services;

import com.admiral.tsp.timesheetportal.Timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepoJPA extends JpaRepository<Timesheet, Long> {
}
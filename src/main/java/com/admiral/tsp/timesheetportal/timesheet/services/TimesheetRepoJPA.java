package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository imports getters and such
@Repository
public interface TimesheetRepoJPA extends JpaRepository<Timesheet, Long> {
}
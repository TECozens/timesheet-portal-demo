package com.admiral.tsp.timesheetportal.data;

import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import org.springframework.data.jpa.repository.JpaRepository;




public interface TimesheetRepoJPA extends TimesheetRepo, JpaRepository<Timesheet, Long> {

}
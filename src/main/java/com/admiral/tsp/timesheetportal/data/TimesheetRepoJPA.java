package com.admiral.tsp.timesheetportal.data;

import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TimesheetRepoJPA extends JpaRepository<Timesheet, Long> {
    List<Timesheet> findByContractor(Contractor charityInstance);
}
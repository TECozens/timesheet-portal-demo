package com.admiral.tsp.timesheetportal.repository;

import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;

import java.util.List;
import java.util.Optional;

public interface TimesheetRepo {

     Optional<Timesheet> findById(Long id);
    List<Timesheet> findByContractorName(Contractor contractor);

}

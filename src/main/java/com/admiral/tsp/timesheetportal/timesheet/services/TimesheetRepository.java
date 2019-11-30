package com.admiral.tsp.timesheetportal.timesheet.services;

import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

    @Query("SELECT t FROM Timesheet t WHERE t.id = :id")
    Optional<Timesheet> getTimesheetById(@Param("id") Integer id);

    @Query("SELECT t FROM Timesheet t")
    List<Timesheet> getAllTimesheets();
}
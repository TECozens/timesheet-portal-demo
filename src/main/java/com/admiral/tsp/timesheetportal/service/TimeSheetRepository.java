package com.admiral.tsp.timesheetportal.service;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {

    @Query("SELECT t FROM TimeSheet t WHERE t.id = :id")
    Optional<TimeSheet> getTimeSheetById(@Param("id") Long id);

    @Query("SELECT t FROM TimeSheet t")
    List<TimeSheet> getAllTimeSheets();

    @Query("SELECT t FROM TimeSheet t WHERE t NOT IN (SELECT r.timeSheet FROM Review r)")
    List<TimeSheet> getUnreviewed();

    @Query("SELECT t FROM TimeSheet t WHERE t.contractor.manager = :manager")
    List<TimeSheet> getByManager(@Param("manager") User manager);

    @Query("SELECT t FROM TimeSheet t WHERE t.contractor.manager = :manager " +
            "AND t NOT IN (SELECT r.timeSheet FROM Review r)")
    List<TimeSheet> getUnreviewedByManager(@Param("manager") User manager);
}
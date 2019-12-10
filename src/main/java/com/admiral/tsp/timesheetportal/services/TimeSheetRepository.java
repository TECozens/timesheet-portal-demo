package com.admiral.tsp.timesheetportal.services;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
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
}
package com.admiral.tsp.timesheetportal.services.event;

import com.admiral.tsp.timesheetportal.domain.Agency;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TimesheetMade {
//    TODO Parse All Fields
    private Contractor contractorInstance;
    private Agency agencyInstance;
    private int daysWorked;
    private int overtime;
}
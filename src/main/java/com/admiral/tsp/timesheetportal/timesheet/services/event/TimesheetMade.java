package com.admiral.tsp.timesheetportal.timesheet.services.event;

import com.admiral.tsp.timesheetportal.agency.Agency;
import com.admiral.tsp.timesheetportal.contractor.Contractor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimesheetMade {
//    TODO Parse All Fields
    private Contractor contractorInstance;
    private Agency agencyInstance;
    private Integer daysWorked;
    private Integer overtime;
}
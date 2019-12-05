package com.admiral.tsp.timesheetportal.services.events;

import com.admiral.tsp.timesheetportal.data.domain.Agency;
import com.admiral.tsp.timesheetportal.data.domain.Contractor;
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
package com.admiral.tsp.timesheetportal.service.events;

import com.admiral.tsp.timesheetportal.data.domain.Agency;
import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimeSheetMade {
//    TODO Parse All Fields
    private Contractor contractorInstance;
    private Agency agencyInstance;
    private Integer daysWorked;
    private Integer overtime;
}
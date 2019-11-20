package com.admiral.tsp.timesheetportal.adaptors;

import com.admiral.tsp.timesheetportal.data.TimesheetRepoJPA;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import com.admiral.tsp.timesheetportal.services.event.TimesheetMade;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TimesheetJPAAdaptor implements TimesheetRepo {

    private TimesheetRepoJPA timesheetRepoJPA;

    public TimesheetJPAAdaptor(TimesheetRepoJPA aTJPARepo) {
        timesheetRepoJPA = aTJPARepo;
    }

    @Override
    public void saveTimesheetToDB(TimesheetMade timesheetInstance) {
        //    TODO Finish Save

    }

    @Override
    public Optional<Timesheet> findById(Long id) {
        return timesheetRepoJPA.findById(id);
    }


}
package com.admiral.tsp.timesheetportal.adaptors;

import com.admiral.tsp.timesheetportal.data.TimesheetRepoJPA;
import com.admiral.tsp.timesheetportal.domain.Agency;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.repository.TimesheetRepo;
import com.admiral.tsp.timesheetportal.services.event.TimesheetMade;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TimesheetJPAAdaptor implements TimesheetRepo {

    private TimesheetRepoJPA timesheetRepoJPA;

    public TimesheetJPAAdaptor(TimesheetRepoJPA aTJPARepo) {
        timesheetRepoJPA = aTJPARepo;
    }

    @Override
    public void saveTimesheetToDB(TimesheetMade timesheetEvent) {
        //    TODO Finish Save


        Agency theAgency = new Agency(
                null,
                timesheetEvent.getAgencyInstance().getName(),
                timesheetEvent.getAgencyInstance().getAgency_email()
                );

        Contractor aContractor = new Contractor(
                timesheetEvent.getContractorInstance().getId(),
                timesheetEvent.getContractorInstance().getName(),
                timesheetEvent.getContractorInstance().getContractor_email(),
                timesheetEvent.getContractorInstance().getAgency(),
                timesheetEvent.getContractorInstance().getTimesheet()
                );

        Timesheet theTimesheet = new Timesheet(
                null,
                timesheetEvent.getContractorInstance(),
                timesheetEvent.getAgencyInstance(),
                timesheetEvent.getDaysWorked(),
                timesheetEvent.getOvertime(),
                LocalDate.now(),
                false
        );


        timesheetRepoJPA.save(theTimesheet);
    }

    @Override
    public Optional<Timesheet> findById(Long id) {
        return timesheetRepoJPA.findById(id);
    }


}
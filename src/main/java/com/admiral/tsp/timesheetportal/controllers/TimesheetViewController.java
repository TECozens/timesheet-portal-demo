package com.admiral.tsp.timesheetportal.controllers;

import com.admiral.tsp.timesheetportal.domain.Agency;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.finder.TimesheetFinder;
import com.admiral.tsp.timesheetportal.services.TimesheetCreator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey"})
public class TimesheetViewController {


    private TimesheetFinder timesheetFinder;

    private TimesheetCreator timesheetCreator;
    @Autowired
    public TimesheetViewController(TimesheetFinder timesheetFinder, TimesheetCreator aTCreator) {
        this.timesheetFinder = timesheetFinder;
        timesheetCreator = aTCreator;}

    static final Logger LOG = LoggerFactory.getLogger(com.admiral.tsp.timesheetportal.controllers.TimesheetViewController.class);


    @GetMapping("Timesheet/{i}")
    public String showTimesheetDashboardPage(@PathVariable("i") Integer index, Model model) {



        createFakeResult();
        Optional<Timesheet> foundTimesheet = timesheetFinder.getFindTimesheetByIndex(index);
        log.info(String.valueOf(foundTimesheet.isPresent()));

        if (foundTimesheet.isPresent()) {
            model.addAttribute("TimesheetKey", foundTimesheet.get());

            return "manager_view";

        } else {
            return "404";
        }
    }

    void createFakeResult(){
        Agency agency = new Agency(
                1L,
                "Agency",
                "xxx@hotmail.com"
        );

        Timesheet timesheet = new Timesheet();

        Contractor contractor = new Contractor(
                1L,
                "John Doe",
                "xxxx@gmail.com",
                agency

        );

        Timesheet newTimesheet = new Timesheet(
                null,
                contractor,
                agency,
                1,
                1,
                LocalDate.now()


        );

        timesheetCreator.makeTimesheet(newTimesheet);

    }


}

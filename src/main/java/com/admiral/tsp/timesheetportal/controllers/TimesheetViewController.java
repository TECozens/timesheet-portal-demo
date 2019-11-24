package com.admiral.tsp.timesheetportal.controllers;

import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.finder.TimesheetFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

@Controller
@SessionAttributes({"TimesheetKey"})
public class TimesheetViewController {


    private TimesheetFinder timesheetFinder;


    public TimesheetViewController(TimesheetFinder timesheetFinder) {
        this.timesheetFinder = timesheetFinder;}

    static final Logger LOG = LoggerFactory.getLogger(com.admiral.tsp.timesheetportal.controllers.TimesheetViewController.class);


    @GetMapping("Timesheet/{i}")
    public String showTimesheetDashboardPage(@PathVariable("i") Integer index, Model model) {

        Optional<Timesheet> foundTimesheet = timesheetFinder.getFindTimesheetByIndex(index);

        if (foundTimesheet.isPresent()) {
            model.addAttribute("TimesheetKey", foundTimesheet.get());

            return "manager_view";

        } else {
            return "404";
        }
    }



}

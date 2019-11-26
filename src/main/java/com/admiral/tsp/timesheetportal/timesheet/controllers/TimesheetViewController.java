package com.admiral.tsp.timesheetportal.timesheet.controllers;

import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetRepoJPA;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetCreator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey"})
public class TimesheetViewController {


    private TimesheetRepoJPA timesheetRepoJPA;

    private TimesheetCreator timesheetCreator;
    @Autowired
    public TimesheetViewController(TimesheetRepoJPA timesheetRepoJPA, TimesheetCreator timesheetCreator) {
        this.timesheetRepoJPA = timesheetRepoJPA;
        this.timesheetCreator = timesheetCreator;
    }

    static final Logger LOG = LoggerFactory.getLogger(TimesheetViewController.class);


    @GetMapping("Timesheet/{i}")
    public String showTimesheetDashboardPage(@PathVariable("i") Integer index, Model model) {



        Optional<Timesheet> foundTimesheet = timesheetRepoJPA.findById(Long.valueOf(index));
        log.info(String.valueOf(foundTimesheet.get()));

        if (foundTimesheet.isPresent()) {
            model.addAttribute("TimesheetKey", foundTimesheet.get());

            return "timesheet_view";

        } else {
            return "404";
        }
    }
    @GetMapping("Approvals")
    public String showTimesheetApprovalPage(Model model){
        List<Timesheet> foundTimesheets = timesheetCreator.getAll();

        model.addAttribute("TimesheetKey", foundTimesheets);

        return "manager_view";

    }



}

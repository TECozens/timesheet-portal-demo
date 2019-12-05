package com.admiral.tsp.timesheetportal.web.controllers.timesheet;

import com.admiral.tsp.timesheetportal.web.forms.review.TimesheetIdPassForm;
import com.admiral.tsp.timesheetportal.data.domain.Timesheet;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimesheetJpa;
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


    @Autowired
    private TimesheetJpa timesheetJpa;

    static final Logger LOG = LoggerFactory.getLogger(TimesheetViewController.class);


    @GetMapping("Timesheet/{i}")
    public String showTimesheetDashboardPage(@PathVariable("i") Long index, Model model) {

        Optional<Timesheet> foundTimesheet = timesheetJpa.getByID(index);
        log.info(String.valueOf(foundTimesheet.get()));

        if (foundTimesheet.isPresent()) {
            model.addAttribute("TimesheetKey", foundTimesheet.get());

            return "timesheet_view";

        } else {
            return "404";
        }
    }
    @GetMapping("/Reviews")
    public String showTimesheetApprovalPage(Model model){
        List<Timesheet> foundTimesheets = timesheetJpa.getAll();

        model.addAttribute("TimesheetKey", foundTimesheets);
        model.addAttribute("TimesheetIdPass", new TimesheetIdPassForm());

        return "manager_view";

    }



}

package com.admiral.tsp.timesheetportal.timesheet.controllers;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import com.admiral.tsp.timesheetportal.contractor.services.ContractorJpa;
import com.admiral.tsp.timesheetportal.contractor.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpa;
import com.admiral.tsp.timesheetportal.timesheet.forms.TimesheetForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey"})
public class TimesheetCreateController {

    @Autowired
    private TimesheetJpa timesheetJpa;
    @Autowired
    private ContractorJpa contractorJpa;



    //    timesheet Form Displayed on Contractor Page
    @PostMapping("/newTimesheet")
    public String timesheetDetails(@ModelAttribute("TimesheetKey") @Valid TimesheetForm timesheetForm,
                                   BindingResult bindingResult, // Keep this after valid
                                   Model model) {

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("timesheet Form has binding errors");

            Authentication a = SecurityContextHolder.getContext().getAuthentication();

            String user = a.getName();

            model.addAttribute("User", user);
            model.addAttribute("contractorTimesheetDetails", timesheetForm);
            return "contractor_view";
        }

//        if details are correct do the submit
        return "redirect:/createTimesheet/";
    }


    @GetMapping("/createTimesheet")
    public String submitTimesheet(@ModelAttribute("TimesheetKey") TimesheetForm timesheetForm,
                                  Model model) {

        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String username = a.getName();

        log.info("The name given is: " + username + " - " + a.getDetails().toString());

//        TODO Fun create stuff
        Contractor thisContractor = contractorJpa.getByUsername(username).get();

        log.info("The contractor given is: " + thisContractor.toString());

        Timesheet newTimesheet = new Timesheet(
                null,
                thisContractor,
                timesheetForm.getDays_worked(),
                timesheetForm.getOvertime_completed(),
                LocalDate.now()
        );


        timesheetJpa.makeTimesheet(newTimesheet);

        log.debug("Here is the timesheet going into DB" + newTimesheet.toString());

        return "redirect:/contractorView";
    }


}

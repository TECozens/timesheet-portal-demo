package com.admiral.tsp.timesheetportal.controllers;

import com.admiral.tsp.timesheetportal.domain.Agency;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.services.TimesheetCreator;
import com.admiral.tsp.timesheetportal.web.TimesheetForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@SessionAttributes({"TimesheetKey"})
public class TimesheetCreateController {

    private TimesheetCreator timesheetCreator;

    @Autowired
    public TimesheetCreateController(TimesheetCreator aTCreator) {
        timesheetCreator = aTCreator;
    }

    static final Logger LOG = LoggerFactory.getLogger(TimesheetCreateController.class);

    //    Timesheet Form Displayed on Contractor Page
    @PostMapping("/newTimesheet")
    public String timesheetDetails(@ModelAttribute("TimesheetKey") @Valid TimesheetForm timesheetForm,
                                   BindingResult bindingResult, // Keep this after valid
                                   Model model) {
        if (bindingResult.hasErrors()) {
            LOG.error(bindingResult.toString());
            LOG.error("Timesheet Form has binding errors");
            model.addAttribute("contractorTimesheetDetails", timesheetForm);
            return "contractor_view";
        }
//        if details are correct do the submit
        return "redirect:/createTimesheet/";
    }

    @GetMapping("/createTimesheet")
    public String submitTimesheet(@ModelAttribute("TimesheetKey") TimesheetForm timesheetForm,
                                  Model model) {

//        TODO Fun create stuff
        Agency agency = new Agency(
                1L,
                "x",
                "x"
        );

        Timesheet timesheet = new Timesheet();

        Contractor contractor = new Contractor(
                1L,
                "x",
                "xxxx@gmail.com",
                agency

        );

        Timesheet newTimesheet = new Timesheet(
                null,
                contractor,
                agency,
                timesheetForm.getDays_worked(),
                timesheetForm.getOvertime_completed(),
                LocalDate.now()


        );


        timesheetCreator.makeTimesheet(newTimesheet);

        LOG.debug("Here is the Timesheet going into DB" + newTimesheet.toString());

        return "redirect:/contractorView";
    }


}

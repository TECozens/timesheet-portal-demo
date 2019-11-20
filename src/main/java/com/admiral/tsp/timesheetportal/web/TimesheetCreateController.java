package com.admiral.tsp.timesheetportal.web;

import com.admiral.tsp.timesheetportal.domain.Agency;
import com.admiral.tsp.timesheetportal.domain.Contractor;
import com.admiral.tsp.timesheetportal.domain.Timesheet;
import com.admiral.tsp.timesheetportal.services.TimesheetCreator;
import com.admiral.tsp.timesheetportal.services.TimesheetService;
import com.admiral.tsp.timesheetportal.services.event.TimesheetMade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Time;

@Controller
@SessionAttributes({"contractorKey", "timeSheetKey", "agencyKey"})
public class TimesheetCreateController {

    private TimesheetCreator timesheetCreator;

    @Autowired
    public TimesheetCreateController(TimesheetCreator aTCreator) {
        timesheetCreator = aTCreator;
    }

    static final Logger LOG = LoggerFactory.getLogger(TimesheetCreateController.class);

    @PostMapping("/timeSheetDetails")
    public String timeSheetDetails(@SessionAttribute("contractorKey") Contractor contractorInstance,
                                   @ModelAttribute("timeSheetKey") @Valid time_sheetForm timesheetForm,
                                   BindingResult bindingResult, // Keep this after valid
                                   Model model) {
        if (bindingResult.hasErrors()) {
            LOG.error(bindingResult.toString());
            LOG.error("Timesheet Form has binding errors");
            model.addAttribute("contractorTimesheetDetails", timesheetForm);
            return "t_fundraiser_details_page";
        }
//        if details are correct do the submit
        return "redirect:/createTimesheet/";
    }

    @GetMapping("/createTimesheet")
    public String submitTimesheet(@SessionAttribute("contractorKey") Contractor contractorInstance,
                                  @ModelAttribute("timeSheetKey") time_sheetForm timesheetForm,
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
                agency,
                timesheet
        );

        TimesheetMade newTimesheet = new TimesheetMade(
                contractor,
                agency,
                timesheetForm.getDays_worked(),
                timesheetForm.getOvertime_completed()
        );

        timesheetCreator.makeTimesheet(newTimesheet);

        return "contractor_profile";
    }


}

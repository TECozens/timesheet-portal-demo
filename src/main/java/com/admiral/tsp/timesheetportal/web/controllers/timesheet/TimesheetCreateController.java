package com.admiral.tsp.timesheetportal.web.controllers.timesheet;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.data.jpa.contractor.ContractorJpa;
import com.admiral.tsp.timesheetportal.data.domain.Timesheet;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimesheetJpa;
import com.admiral.tsp.timesheetportal.web.forms.timesheet.TimesheetForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;

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
                                        RedirectAttributes model) {

        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String username = a.getName();

        log.info("The name given is: " + username + " - " + a.getDetails().toString());

//        TODO Fun create stuff
        System.out.println("The name given is: " + username + " - " + a.getDetails().toString());
        Contractor thisContractor = contractorJpa.getByUsername(username).get();

        log.info("The contractor given is: " + thisContractor.toString());

        Timesheet newTimesheet = new Timesheet(
                null,
                thisContractor,
                timesheetForm.getDays_worked(),
                timesheetForm.getOvertime_completed(),
                timesheetForm.getWeek_ending()
        );


        timesheetJpa.makeTimesheet(newTimesheet);

        System.out.println("Here is the timesheet going into DB" + newTimesheet.toString());
        model.addFlashAttribute("aTimesheet", newTimesheet);
        return "redirect:/contractorView";
    }


}

package com.admiral.tsp.timesheetportal.timesheet.controllers;

import com.admiral.tsp.timesheetportal.agency.Agency;
import com.admiral.tsp.timesheetportal.contractor.Contractor;
import com.admiral.tsp.timesheetportal.contractor.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.data.UserRepository;
import com.admiral.tsp.timesheetportal.domain.User;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpaRepo;
import com.admiral.tsp.timesheetportal.timesheet.forms.TimesheetForm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
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

    private TimesheetJpaRepo timesheetJpaRepo;
    private UserRepository userJpaRepo;
    private ContractorRepository contractorJpaRepo;

    @Autowired
    public TimesheetCreateController(TimesheetJpaRepo aTCreator,
                                     UserRepository userRepository,
                                     ContractorRepository contractorRepository) {
//        This needs to be changed in the future as
//        by doing this it had a direct dependency
        timesheetJpaRepo = aTCreator;
        userJpaRepo = userRepository;
        contractorJpaRepo = contractorRepository;
    }


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

        String user = a.getName();
        a.getDetails();
        log.info("The name given is: " + user + " - " + a.getDetails().toString());

        User thisUser = userJpaRepo.findByUsername(user);

        log.info("The user given is: " + thisUser.toString());

//        TODO Fun create stuff
        Contractor thisContractor = contractorJpaRepo.findContractorByUser(thisUser);

        log.info("The contractor given is: " + thisContractor.toString());

        Timesheet newTimesheet = new Timesheet(
                null,
                thisContractor,
                timesheetForm.getDays_worked(),
                timesheetForm.getOvertime_completed(),
                LocalDate.now()
        );


        timesheetJpaRepo.makeTimesheet(newTimesheet);

        log.debug("Here is the timesheet going into DB" + newTimesheet.toString());

        return "redirect:/contractorView";
    }


}

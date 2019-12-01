package com.admiral.tsp.timesheetportal.review.controllers;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import com.admiral.tsp.timesheetportal.contractor.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.data.UserRepository;
import com.admiral.tsp.timesheetportal.domain.User;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.forms.TimesheetForm;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey", "ReviewKey"})
public class ApprovalPerformanceReviewCreateController {
//
//    private TimesheetJpa timesheetJpa;
//    private UserRepository userJpaRepo;
//    private ContractorRepository contractorJpaRepo;
//
//    @Autowired
//    public ApprovalPerformanceReviewCreateController(TimesheetJpa aTCreator,
//                                                     UserRepository userRepository,
//                                                     ContractorRepository contractorRepository) {
////        This needs to be changed in the future as
////        by doing this it had a direct dependency
//        timesheetJpa = aTCreator;
//        userJpaRepo = userRepository;
//        contractorJpaRepo = contractorRepository;
//    }
//
//
//    //    timesheet Form Displayed on Contractor Page
//    @PostMapping("/newTimesheet")
//    public String timesheetDetails(@ModelAttribute("TimesheetKey") @Valid TimesheetForm timesheetForm,
//                                   BindingResult bindingResult, // Keep this after valid
//                                   Model model) {
//
//        if (bindingResult.hasErrors()) {
//
//            log.error(bindingResult.toString());
//            log.error("timesheet Form has binding errors");
//
//            Authentication a = SecurityContextHolder.getContext().getAuthentication();
//
//            String user = a.getName();
//
//            model.addAttribute("User", user);
//            model.addAttribute("contractorTimesheetDetails", timesheetForm);
//            return "contractor_view";
//        }
//
////        if details are correct do the submit
//        return "redirect:/createTimesheet/";
//    }
//
//
//    @GetMapping("/createTimesheet")
//    public String submitTimesheet(@ModelAttribute("TimesheetKey") TimesheetForm timesheetForm,
//                                  Model model) {
//
//        Authentication a = SecurityContextHolder.getContext().getAuthentication();
//
//        String user = a.getName();
//        a.getDetails();
//        log.info("The name given is: " + user + " - " + a.getDetails().toString());
//
//        User thisUser = userJpaRepo.findByUsername(user);
//
//        log.info("The user given is: " + thisUser.toString());
//
////        TODO Fun create stuff
//        Contractor thisContractor = contractorJpaRepo.getContractorByUser(thisUser).get();
//
//        log.info("The contractor given is: " + thisContractor.toString());
//
//        Timesheet newTimesheet = new Timesheet(
//                null,
//                thisContractor,
//                timesheetForm.getDays_worked(),
//                timesheetForm.getOvertime_completed(),
//                LocalDate.now()
//        );
//
//
//        timesheetJpa.makeTimesheet(newTimesheet);
//
//        log.debug("Here is the timesheet going into DB" + newTimesheet.toString());
//
//        return "redirect:/contractorView";
//    }


}

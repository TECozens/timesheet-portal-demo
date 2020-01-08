package com.admiral.tsp.timesheetportal.web.controllers.timesheet;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.data.jpa.ContractorJpa;
import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.data.jpa.TimeSheetJpa;
import com.admiral.tsp.timesheetportal.web.controllers.email.EmailManager;
import com.admiral.tsp.timesheetportal.web.forms.timesheet.TimeSheetForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@Controller
@SessionAttributes({"TimeSheetKey"})
public class TimeSheetCreateController {

    private final TimeSheetJpa timesheetJpa;
    private final ContractorJpa contractorJpa;

    @Autowired
    public TimeSheetCreateController(TimeSheetJpa timesheetJpa, ContractorJpa contractorJpa) {
        this.timesheetJpa = timesheetJpa;
        this.contractorJpa = contractorJpa;
    }


    //    timeSheet Form Displayed on Contractor Page
    @PostMapping("/newTimeSheet")
    public String timeSheetDetails(@ModelAttribute("TimeSheetKey") @Valid TimeSheetForm timeSheetForm,
                                   BindingResult bindingResult, // Keep this after valid
                                   Model model) {

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("timeSheet Form has binding errors");

            Authentication a = SecurityContextHolder.getContext().getAuthentication();

            String user = a.getName();

            model.addAttribute("User", user);
            model.addAttribute("TimeSheetKey", timeSheetForm);
            return "contractor_view";
        }

//        if details are correct do the submit
        return "redirect:/createTimeSheet/";
    }


    @GetMapping("/createTimeSheet")
    public String submitTimeSheet(@ModelAttribute("TimeSheetKey") TimeSheetForm timeSheetForm,
                                        RedirectAttributes model) throws IOException, MessagingException {

        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String username = a.getName();

        log.info("The name given is: " + username + " - " + a.getDetails().toString());

        Contractor thisContractor = contractorJpa.getByUsername(username).get();

        log.info("The contractor given is: " + thisContractor.toString());

        Integer overtime = (timeSheetForm.getOvertime_completed() != null
                ? timeSheetForm.getOvertime_completed() : 0);

        TimeSheet newTimeSheet = new TimeSheet(
                null,
                thisContractor,
                timeSheetForm.getDays_worked(),
                overtime,
                timeSheetForm.getWeek_ending()
        );


        timesheetJpa.makeTimeSheet(newTimeSheet);
        log.info("Here is the timeSheet going into DB" + newTimeSheet.toString());
        model.addFlashAttribute("aTimeSheet", newTimeSheet);


        EmailManager emailManager = new EmailManager();
        emailManager.sendManagerMail(thisContractor.getManager());


        return "redirect:/contractorView";
    }


}

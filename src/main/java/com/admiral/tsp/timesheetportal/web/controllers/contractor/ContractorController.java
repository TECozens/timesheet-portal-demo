package com.admiral.tsp.timesheetportal.web.controllers.contractor;

import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.web.forms.timesheet.TimeSheetForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@SessionAttributes({"contractorKey", "TimeSheetKey"})
public class ContractorController {


    //  Contractor Page
    @GetMapping("/contractorView")
    public String doContractorProfile(@ModelAttribute("aTimeSheet") TimeSheet aTimeSheet,
            Model model)
    {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String user = a.getName();
        model.addAttribute("aTimeSheet", aTimeSheet);

        model.addAttribute("User", user);
        model.addAttribute("TimeSheetKey", new TimeSheetForm());
        return "contractor_view";
    }
}

package com.admiral.tsp.timesheetportal.contractor.controllers;

import com.admiral.tsp.timesheetportal.timesheet.forms.TimesheetForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"contractorKey", "TimesheetKey"})
public class ContractorController {

    static final Logger LOG = LoggerFactory.getLogger(ContractorController.class);

    //  Contractor Page
    @GetMapping("/contractorView")
    public String doContractorProfile(Model model)
    {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String user = a.getName();

        model.addAttribute("User", user);
        model.addAttribute("TimesheetKey", new TimesheetForm());
        return "contractor_view";
    }
}

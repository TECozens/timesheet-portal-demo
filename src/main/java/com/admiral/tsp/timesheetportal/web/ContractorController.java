package com.admiral.tsp.timesheetportal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes({"contractorKey", "timeSheetKey"})
public class ContractorController {

    static final Logger LOG = LoggerFactory.getLogger(ContractorController.class);

    //  Contractor Profile Page
    @GetMapping("/contractorProfile")
    public String doContractorProfile(Model model)
    {
        return "contractor_profile";
    }

    //  Contractor Profile Page
    @GetMapping("/newTimesheet")
    public String doTimesheet(Model model)
    {
        LOG.debug("Putting timesheet on  model and therefore on session");
        model.addAttribute("timeSheetKey", new time_sheetForm());
        return "/timeSheetDetails";
    }
}

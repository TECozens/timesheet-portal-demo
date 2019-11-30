package com.admiral.tsp.timesheetportal.admin.controllers;

import com.admiral.tsp.timesheetportal.contractor.controllers.ContractorController;
import com.admiral.tsp.timesheetportal.timesheet.forms.TimesheetForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"contractorKey", "TimesheetKey", "managerKey"})
public class AdminManageRoles {
    static final Logger LOG = LoggerFactory.getLogger(ContractorController.class);

    //  Contractor Page
    @GetMapping("/ManageRoles")
    public String doManageRolesView(Model model)
    {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String user = a.getName();

        model.addAttribute("User", user);
        return "admin_manage_roles_view";
    }
}

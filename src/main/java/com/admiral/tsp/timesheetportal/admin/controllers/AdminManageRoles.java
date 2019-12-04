package com.admiral.tsp.timesheetportal.admin.controllers;

import com.admiral.tsp.timesheetportal.contractor.controllers.ContractorController;
import com.admiral.tsp.timesheetportal.contractor.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.data.UserRepository;
import com.admiral.tsp.timesheetportal.data.UserRolesRepository;
import com.admiral.tsp.timesheetportal.domain.User;
import com.admiral.tsp.timesheetportal.domain.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"contractorKey", "managerKey"})
public class AdminManageRoles {
    static final Logger LOG = LoggerFactory.getLogger(ContractorController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContractorRepository contractorRepository;


    //  Manager Roles Page
    @GetMapping("/ManageRoles")
    public String doManageRolesView(Model model) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String user = a.getName();

        model.addAttribute("User", user);
        return "admin_manage_roles_view";
    }

    //    MANAGER DROPDOWN
    @GetMapping("/managerSelectList")
    public String managerSelectOption(Model model) {
        List<User> managers = userRepository.findByManagerRole();
        model.addAttribute("managerKey", managers);


        return "managerSelectOption";
    }

    //    TODO List of Contractors to Assign to a Manager Vice Versa
    @GetMapping("/contractorList/{i}")
    public String getContractorList(@PathVariable("i") Integer index, Model model) {

        return "admin_select_contractors_list";
    }

    //    TODO Update the Contractor with new Manager from Select
    @PostMapping("/updateContractorAssignee")
    public String updateContractorAssignee(@PathVariable String managerInstance,
                                           Model model) {

        return "x";
    }
}

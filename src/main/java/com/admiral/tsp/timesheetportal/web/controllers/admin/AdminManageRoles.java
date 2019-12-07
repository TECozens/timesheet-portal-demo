package com.admiral.tsp.timesheetportal.web.controllers.admin;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.data.jpa.contractor.ContractorJpa;
import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
import com.admiral.tsp.timesheetportal.web.controllers.contractor.ContractorController;
import com.admiral.tsp.timesheetportal.data.domain.User;
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
    private UserJpa userJpa;

    @Autowired
    private ContractorJpa contractorJpa;

    //  Manager Roles Page
    @GetMapping("/ManageRoles")
    public String doManageRolesView(Model model) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String user = a.getName();

        model.addAttribute("User", user);
        List<User> managers = userJpa.findManagers();
        model.addAttribute("managerKey", managers);
        return "admin_manage_roles_view";
    }

    //    TODO List of Contractors to Assign to a Manager Vice Versa
    @GetMapping("/contractorList/{i}")
    public String getContractorList(@PathVariable("i") Integer index, Model model) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String user = a.getName();
        model.addAttribute("User", user);

        User manager = userJpa.getById(index.longValue());
        model.addAttribute("Manager", manager);

        List<Contractor> foundContractors = contractorJpa.getAll();
        model.addAttribute("Contractors", foundContractors);

        return "admin_select_contractors_list";
    }

//    //    TODO Update the Contractor with new Manager from Select
//    @PostMapping("/assignContractor/{id}")
//    public String assignContractor(@PathVariable("id") Long index,
//                                   @SessionAttribute("managerKey") User manager,
//                                   @SessionAttribute("contractorKey") Contractor contractor,
//                                   Model model) {
//        Authentication a = SecurityContextHolder.getContext().getAuthentication();
//
//        String user = a.getName();
//        model.addAttribute("User", user);
//
//        contractor.setManager(manager);
//
//        contractorRepository.updateContractor(manager,index);
//
//        return "redirect:/manageRoles";
//    }
}

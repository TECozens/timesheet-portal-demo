package com.admiral.tsp.timesheetportal.web.controllers.admin;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.web.controllers.contractor.ContractorController;
import com.admiral.tsp.timesheetportal.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.security.data.domain.User;
import com.admiral.tsp.timesheetportal.security.services.UserRepository;
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
        List<User> managers = userRepository.findByManagerRole();
        model.addAttribute("managerKey", managers);
        return "admin_manage_roles_view";
    }

    //    TODO List of Contractors to Assign to a Manager Vice Versa
    @GetMapping("/contractorList/{i}")
    public String getContractorList(@PathVariable("i") Integer index, Model model) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();

        String user = a.getName();
        model.addAttribute("User", user);

        User manager = userRepository.getUserById(index.longValue());
        model.addAttribute("Manager", manager);

        List<Contractor> foundContractors = contractorRepository.getAllContractor();
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
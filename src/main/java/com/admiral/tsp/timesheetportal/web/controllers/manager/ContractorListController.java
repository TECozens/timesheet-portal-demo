package com.admiral.tsp.timesheetportal.web.controllers.manager;

import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.jpa.ContractorJpa;
import com.admiral.tsp.timesheetportal.data.jpa.UserJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ContractorListController {


    private final ContractorJpa contractorJpa;
    private final UserJpa userJpa;

    @Autowired
    public ContractorListController(ContractorJpa contractorJpa, UserJpa userJpa) {
        this.contractorJpa = contractorJpa;
        this.userJpa = userJpa;
    }


    @GetMapping("/Contractors")
    public String showTimeSheetApprovalPage(Model model){


        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        String username = a.getName();
        User manager = userJpa.getByUsername(username);
        List<Contractor> contractors = contractorJpa.getManagerContractors(manager);

        model.addAttribute("Contractors", contractors);

        return "contractor_list_view";

    }



}


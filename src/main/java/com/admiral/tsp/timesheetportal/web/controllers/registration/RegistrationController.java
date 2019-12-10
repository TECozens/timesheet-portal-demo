package com.admiral.tsp.timesheetportal.web.controllers.registration;

import com.admiral.tsp.timesheetportal.data.domain.Agency;
import com.admiral.tsp.timesheetportal.data.jpa.agency.AgencyJpa;
import com.admiral.tsp.timesheetportal.data.domain.Contractor;
import com.admiral.tsp.timesheetportal.data.jpa.contractor.ContractorJpa;
import com.admiral.tsp.timesheetportal.data.domain.User;
import com.admiral.tsp.timesheetportal.data.domain.UserRole;
import com.admiral.tsp.timesheetportal.data.jpa.user.UserJpa;
import com.admiral.tsp.timesheetportal.web.forms.registration.AgencyForm;
import com.admiral.tsp.timesheetportal.web.forms.registration.RegistrationForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes({"registerKey","agencyKey","managerKey"})
public class RegistrationController {

    private final PasswordEncoder passwordEncoder;
    private final UserJpa userJpa;
    private final AgencyJpa agencyJpa;
    private final ContractorJpa contractorJpa;

    @Autowired
    public RegistrationController(PasswordEncoder passwordEncoder,
                                  UserJpa userJpa,
                                  AgencyJpa agencyJpa,
                                  ContractorJpa contractorJpa) {
        this.passwordEncoder = passwordEncoder;
        this.userJpa = userJpa;
        this.agencyJpa = agencyJpa;
        this.contractorJpa = contractorJpa;
    }

    // Creating a new User

    @GetMapping("/register")
    public String goToRegister(Model model) {

        List<User> managers = userJpa.findManagers();

        List<Agency> agency = agencyJpa.findAll();

        model.addAttribute("registerKey", new RegistrationForm());
        model.addAttribute("managerKey", managers);
        model.addAttribute("agencyKey", agency);

        return "register";
    }

    @PostMapping("/newUser")
    public String userDetails(@Valid @ModelAttribute("registerKey") RegistrationForm registrationForm,
                              BindingResult bindingResult,
                              Model model) {

        List<User> managers = userJpa.findManagers();
        List<Agency> agency = agencyJpa.findAll();

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("Registration Form has binding errors");

            model.addAttribute("managerKey", managers);
            model.addAttribute("agencyKey", agency);
            model.addAttribute("registerKey", registrationForm);
            return "register";

        }

        return "redirect:/createUser/";

    }

    @GetMapping("/createUser")
    public String submitRegistration(@ModelAttribute("registerKey") RegistrationForm registrationForm) {
        
        User newUser = new User(
                null,
                registrationForm.getUsername(),
                registrationForm.getFirstname(),
                registrationForm.getSurname(),
                registrationForm.getEmail(),
                passwordEncoder.encode(registrationForm.getPassword())

        );

        userJpa.makeUser(newUser);

        UserRole newRole = new UserRole();
        newRole.setUserid(newUser.getId());
        newRole.setRole(registrationForm.getRole());

        userJpa.makeUserRole(newRole);
        log.info(newRole.getRole());

        if (newRole.getRole().equals("ROLE_CONTRACTOR")){
            Contractor newContractor = new Contractor();
            newContractor.setUser(newUser);
            newContractor.setAgency(agencyJpa.findByID(registrationForm.getAgencyId()));
            newContractor.setManager(userJpa.getById(registrationForm.getManagerId()));

            contractorJpa.makeContractor(newContractor);

        }

        log.debug("New User going into DB" + newUser.toString());

        return "redirect:/Invoices";

    }


    // Creating a new Agency

    @GetMapping("/registerAgency")
    public String goToAgencyRegister(Model model) {
        model.addAttribute("agencyKey", new AgencyForm());
        return "registerAgency";
    }

    @PostMapping("/newAgency")
    public String agencyDetails(@ModelAttribute("agencyKey") @Valid AgencyForm agencyForm,
                              BindingResult bindingResult,
                              Model model) {

        Agency agency = new Agency();

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("Agency Registration Form has binding errors");

            model.addAttribute("Agency", agency);
            model.addAttribute("agencyRegistrationDetails", agencyForm);
            return "registerAgency";

        }

        return "redirect:/createAgency/";

    }

    @GetMapping("/createAgency")
    public String submitAgencyRegistration(@ModelAttribute("agencyKey") AgencyForm agencyForm) {

        Agency newAgency = new Agency(
                null,
                agencyForm.getName(),
                agencyForm.getEmail()
        );

        agencyJpa.makeAgency(newAgency);

        log.debug("New User going into DB" + newAgency.toString());

        return "redirect:/Invoices";

    }

}

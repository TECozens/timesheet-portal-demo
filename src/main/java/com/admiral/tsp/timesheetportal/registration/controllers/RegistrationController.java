package com.admiral.tsp.timesheetportal.registration.controllers;

import com.admiral.tsp.timesheetportal.agency.Agency;
import com.admiral.tsp.timesheetportal.agency.services.AgencyJpa;
import com.admiral.tsp.timesheetportal.csrf.User;
import com.admiral.tsp.timesheetportal.csrf.UserRole;
import com.admiral.tsp.timesheetportal.csrf.services.UserRepository;
import com.admiral.tsp.timesheetportal.registration.forms.AgencyForm;
import com.admiral.tsp.timesheetportal.registration.forms.RegistrationForm;
import com.admiral.tsp.timesheetportal.registration.services.RegistrationJpa;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes({"registerKey","agencyKey"})
public class RegistrationController {

    @Autowired
    private RegistrationJpa registrationJpa;
    @Autowired
    private AgencyJpa agencyJpa;
    @Autowired
    private PasswordEncoder passwordEncoder;


    static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    // Creating a new User

    @GetMapping("/register")
    public String goToRegister(Model model) {
        model.addAttribute("registerKey", new RegistrationForm());
        return "register";
    }

    @PostMapping("/newUser")
    public String userDetails(@ModelAttribute("registerKey") @Valid RegistrationForm registrationForm,
                              BindingResult bindingResult,
                              Model model) {

        User user = new User();

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("Registration Form has binding errors");

            model.addAttribute("User", user);
            model.addAttribute("registrationDetails", registrationForm);
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

        registrationJpa.makeUser(newUser);

        UserRole newRole = new UserRole();
        newRole.setUserid(newUser.getId());
        newRole.setRole(registrationForm.getRole());

        registrationJpa.makeRole(newRole);

        log.debug("New User going into DB" + newUser.toString());

        return "redirect:/login";

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

        registrationJpa.makeAgency(newAgency);

        log.debug("New User going into DB" + newAgency.toString());

        return "redirect:/login";

    }

}

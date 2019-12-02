package com.admiral.tsp.timesheetportal.registration.controllers;

import com.admiral.tsp.timesheetportal.agency.services.AgencyJpa;
import com.admiral.tsp.timesheetportal.csrf.User;
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
@SessionAttributes({"registerKey"})
public class RegistrationController {

    @Autowired
    private RegistrationJpa registrationJpa;
    @Autowired
    private AgencyJpa agencyJpa;
    @Autowired
    private PasswordEncoder passwordEncoder;


    static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

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

//        UserRole newRole = new UserRole(
//                null,
//                newUser.getId(),
//                registrationForm.getRole()
//        );

        registrationJpa.makeUser(newUser);
//        registrationJpa.makeUser(newRole);

        log.debug("New User going into DB" + newUser.toString());

        return "redirect:/register";

    }


}

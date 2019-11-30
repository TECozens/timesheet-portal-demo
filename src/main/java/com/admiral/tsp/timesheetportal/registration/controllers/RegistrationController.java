package com.admiral.tsp.timesheetportal.registration.controllers;

//import com.admiral.tsp.timesheetportal.agency.services.AgencyRepository;
import com.admiral.tsp.timesheetportal.data.UserRepository;
import com.admiral.tsp.timesheetportal.domain.User;
import com.admiral.tsp.timesheetportal.registration.forms.RegistrationForm;
import com.admiral.tsp.timesheetportal.registration.services.RegistrationJpa;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes({"registerKey"})
public class RegistrationController {

    private RegistrationJpa registrationJpa;
    private UserRepository userRepository;
//    private AgencyRepository agencyRepository;

    @Autowired
    public RegistrationController(RegistrationJpa aRegistrationJpa,
                                  UserRepository aUserRepository
//                                  AgencyRepository aAgencyRepository
    ){
        this.registrationJpa = aRegistrationJpa;
        this.userRepository = aUserRepository;
//        this.agencyRepository = aAgencyRepository;
    }

    static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/register")
    public String goToRegister() {return "register";}

    @PostMapping("/newUser")
    public String userDetails(@ModelAttribute("registerKey") @Valid RegistrationForm registrationForm,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("Registration Form has binding errors");

            model.addAttribute("registrationDetails", registrationForm);
            return "registration";

        }

        return "redirect:/createUser";

    }

    @GetMapping("/createUser")
    public String submitRegistration(@ModelAttribute("registerKey") RegistrationForm registrationForm,
                                     Model model) {

        User newUser = new User(
                null,
                registrationForm.getUsername(),
                registrationForm.getFirstname(),
                registrationForm.getSurname(),
                registrationForm.getEmail(),
                registrationForm.getPassword()
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

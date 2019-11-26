package com.admiral.tsp.timesheetportal.controllers;

import com.admiral.tsp.timesheetportal.web.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    //Login Page
//    @GetMapping("/login")
//    public String goToLogin(){
//        return "login";
//    }

    //Register Page
    @GetMapping("/register")
    public String goToRegister() {return "register";}

//    @RequestMapping(path = "userDetails", method = RequestMethod.POST)
//    public String donorDetails(@ModelAttribute("userKey") @Valid UserForm user, //from form
//                               BindingResult bindingResult,
//                               Model model) {
//
//        if (bindingResult.hasErrors()) {
//            LOG.error(bindingResult.toString());
//            LOG.error("User Form has binding errors");
//            return "t_donor_details_page";
//        }
//
//        LOG.debug(user.toString());
//
//
//        model.addAttribute("paymentKey", new PaymentForm());
//
//
//        return "t_donation_payment_page";
//    }

}

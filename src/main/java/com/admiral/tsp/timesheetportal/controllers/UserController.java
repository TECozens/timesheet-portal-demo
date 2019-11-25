package com.admiral.tsp.timesheetportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {

    static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    //Login Page
    @GetMapping("/login")
    public String goToLogin(){
        return "login";
    }

    //Register Page
    @GetMapping("/register")
    public String goToRegister() {return "register";}

}

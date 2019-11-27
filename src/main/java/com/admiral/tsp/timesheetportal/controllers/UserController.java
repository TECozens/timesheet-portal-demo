package com.admiral.tsp.timesheetportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    //Register Page
    @GetMapping("/register")
    public String goToRegister() {return "register";}

}

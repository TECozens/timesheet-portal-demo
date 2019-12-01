package com.admiral.tsp.timesheetportal.review.controllers;

import com.admiral.tsp.timesheetportal.review.Review;
import com.admiral.tsp.timesheetportal.review.services.ReviewJpa;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ReviewViewController {


    @Autowired
    private ReviewJpa reviewJpa;


    @GetMapping("/Invoices")
    public String showTimesheetApprovalPage(Model model){
        List<Review> foundReviews = reviewJpa.getUnpaid();
        System.out.print("HEY HERE");

        model.addAttribute("Reviews", foundReviews);

        return "invoice_list_view";

    }



}


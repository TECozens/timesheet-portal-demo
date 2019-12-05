package com.admiral.tsp.timesheetportal.web.controllers.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.data.jpa.review.ReviewJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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


package com.admiral.tsp.timesheetportal.web.controllers.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.data.jpa.ReviewJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class ReviewViewController {


    private final ReviewJpa reviewJpa;

    @Autowired
    public ReviewViewController(ReviewJpa reviewJpa) {
        this.reviewJpa = reviewJpa;
    }


    @GetMapping("/Invoices")
    public String showTimeSheetApprovalPage(Model model){
        List<Review> foundReviews = reviewJpa.getUnpaid();

        model.addAttribute("Reviews", foundReviews);

        return "invoice_list_view";

    }



}


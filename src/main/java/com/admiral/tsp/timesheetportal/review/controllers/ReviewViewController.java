package com.admiral.tsp.timesheetportal.review.controllers;

import com.admiral.tsp.timesheetportal.review.Review;
import com.admiral.tsp.timesheetportal.review.services.ReviewJpaRepo;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.controllers.TimesheetViewController;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpaRepo;
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
    private ReviewJpaRepo reviewJpaRepo;


//    @GetMapping("Invoice/{i}")
//    public String showInvoiceDashboardPage(@PathVariable("i") Integer index, Model model) {
//
//
//
//        Optional<Review> foundReview = reviewJpaRepo.getByID(Long.valueOf(index));
//        log.info(String.valueOf(foundReview.get()));
//
//        if (foundReview.isPresent()) {
//            model.addAttribute("review", foundReview.get());
//
//            return "invoice_list_view";
//
//        } else {
//            return "404";
//        }
//    }
    @GetMapping("/Invoice")
    public String showTimesheetApprovalPage(Model model){
        List<Review> foundReviews = reviewJpaRepo.getAll();

        model.addAttribute("Reviews", foundReviews);

        return "invoice_list_view";

    }



}


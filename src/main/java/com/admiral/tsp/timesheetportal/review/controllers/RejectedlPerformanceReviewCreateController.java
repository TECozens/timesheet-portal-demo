package com.admiral.tsp.timesheetportal.review.controllers;

import com.admiral.tsp.timesheetportal.review.Review;
import com.admiral.tsp.timesheetportal.review.forms.RejectionReviewForm;
import com.admiral.tsp.timesheetportal.review.services.ReviewJpa;
import com.admiral.tsp.timesheetportal.review.services.ReviewRepository;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey", "ReviewKey"})
public class RejectedlPerformanceReviewCreateController {

    @Autowired
    private TimesheetJpa timesheetJpa;
    @Autowired
    private ReviewJpa reviewJpa;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    public RejectedlPerformanceReviewCreateController(ReviewJpa aRCreator,
                                                      ReviewRepository reviewRepository) {
        reviewJpa = aRCreator;
        this.reviewRepository = reviewRepository;

    }

    //       Review Form Displayed on Contractor Page
    @PostMapping("/newRejectedReview")
    public String approvereviewDetails(@ModelAttribute("ReviewKey") @Valid RejectionReviewForm RejectionReviewForm,
                                       BindingResult bindingResult, // Keep this after valid
                                       Model model) {

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("review Form has binding errors");

            model.addAttribute("RejectedreviewDetails", RejectionReviewForm);
            return "review_approval";
        }

////        if details are correct do the submit
        return "redirect:/createReview/";
    }


    @GetMapping("/createRejectedReview")
    public String submitApproveReview(@ModelAttribute("ReviewKey") RejectionReviewForm rejectionReviewForm,
                                  Model model) {

                        Review newReview = new Review(
                                false,
                                false,
                                rejectionReviewForm.getTimesheet(),
                                rejectionReviewForm.getMessage()

        );


        reviewJpa.makeReview(newReview);

        log.debug("Here is the review going into DB" + newReview.toString());

        return "redirect:/review_reject";
    }

}
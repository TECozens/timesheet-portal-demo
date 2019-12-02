package com.admiral.tsp.timesheetportal.review.controllers;

import com.admiral.tsp.timesheetportal.contractor.Contractor;
import com.admiral.tsp.timesheetportal.contractor.services.ContractorRepository;
import com.admiral.tsp.timesheetportal.data.UserRepository;
import com.admiral.tsp.timesheetportal.domain.User;
import com.admiral.tsp.timesheetportal.review.Review;
import com.admiral.tsp.timesheetportal.review.forms.ApprovalReviewForm;
import com.admiral.tsp.timesheetportal.review.services.ReviewJpa;
import com.admiral.tsp.timesheetportal.review.services.ReviewRepository;
import com.admiral.tsp.timesheetportal.timesheet.Timesheet;
import com.admiral.tsp.timesheetportal.timesheet.forms.TimesheetForm;
import com.admiral.tsp.timesheetportal.timesheet.services.TimesheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey", "ReviewKey"})
public class ApprovalPerformanceReviewCreateController {

    @Autowired
    private TimesheetJpa timesheetJpa;
    @Autowired
    private ReviewJpa reviewJpa;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    public ApprovalPerformanceReviewCreateController(ReviewJpa aRCreator,
                                                     ReviewRepository reviewRepository) {
        reviewJpa = aRCreator;
        this.reviewRepository = reviewRepository;

    }

    //       Review Form Displayed on reviewing Page
    @PostMapping("/newApproveReview")
    public String approvereviewDetails(@ModelAttribute("ReviewKey") @Valid ApprovalReviewForm ApprovalReviewForm,
                                       BindingResult bindingResult, // Keep this after valid
                                       Model model) {

        if (bindingResult.hasErrors()) {

            log.error(bindingResult.toString());
            log.error("review Form has binding errors");

            model.addAttribute("ApprovalreviewDetails", ApprovalReviewForm);
            return "review_approval";
        }

////        if details are correct do the submit
        return "redirect:/createReview/";
    }


    @GetMapping("/createReview")
    public String submitApproveReview(@ModelAttribute("ReviewKey") ApprovalReviewForm approvalReviewForm,
                                  Model model) {

                               Review newReview = new Review(
                               true,
                                false,
                                       approvalReviewForm.getMessage(),
                                approvalReviewForm.getTimesheet(),
                                approvalReviewForm.getCommunication(),
                                approvalReviewForm.getTechnical_skills(),
                                approvalReviewForm.getQuality(),
                                approvalReviewForm.getInitative(),
                                approvalReviewForm.getProductivity (),
                                approvalReviewForm.getWorking_relations()

        );


        reviewJpa.makeReview(newReview);

        log.debug("Here is the review going into DB" + newReview.toString());

        return "redirect:/review_approval";
    }

}
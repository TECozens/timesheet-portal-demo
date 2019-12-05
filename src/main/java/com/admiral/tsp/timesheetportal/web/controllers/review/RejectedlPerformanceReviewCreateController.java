package com.admiral.tsp.timesheetportal.web.controllers.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.web.forms.review.RejectionReviewForm;
import com.admiral.tsp.timesheetportal.data.jpa.review.ReviewJpa;
import com.admiral.tsp.timesheetportal.services.ReviewRepository;
import com.admiral.tsp.timesheetportal.data.domain.Timesheet;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimesheetJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@SessionAttributes({"TimesheetKey"})
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
    @PostMapping("/newRejectedReview/{id}")
    public String approvereviewDetails(@PathVariable("id") Long id,
//                                       BindingResult bindingResult, // Keep this after valid
                                       Model model) {

//        if (bindingResult.hasErrors()) {
//
//            log.error(bindingResult.toString());
//            log.error("review Form has binding errors");


            Optional<Timesheet> ts = timesheetJpa.getByID(id);
            RejectionReviewForm rejectionReviewForm = new RejectionReviewForm();

            rejectionReviewForm.setTimesheet(ts.get());

            model.addAttribute("RejectedreviewDetails", rejectionReviewForm);
            return "review_reject";
        }

////        if details are correct do the submit
//        return "redirect:/createReview/";
//    }


    @PostMapping("/createRejectedReview")
    public String submitApproveReview(@ModelAttribute("ReviewKey") RejectionReviewForm rejectionReviewForm,
                                  Model model) {
        System.out.println(rejectionReviewForm.getTimesheet());

        Review newReview = new Review( null,
                rejectionReviewForm.getTimesheet(),
                false,
                false,
                rejectionReviewForm.getMessage(),
                rejectionReviewForm.getCommunication(),
                rejectionReviewForm.getTechnical_skills(),
                rejectionReviewForm.getQuality(),
                rejectionReviewForm.getInitative(),
                rejectionReviewForm.getProductivity(),
                rejectionReviewForm.getWorking_relationships()

        );

        System.out.println(reviewJpa.makeReview(newReview).toString());

        log.debug("Here is the review going into DB" + newReview.toString());

        return "redirect:/Reviews";
    }

}
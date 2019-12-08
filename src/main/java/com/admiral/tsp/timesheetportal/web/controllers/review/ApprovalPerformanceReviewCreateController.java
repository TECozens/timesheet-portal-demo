package com.admiral.tsp.timesheetportal.web.controllers.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimeSheetJpa;
import com.admiral.tsp.timesheetportal.web.forms.review.ApprovalReviewForm;
import com.admiral.tsp.timesheetportal.data.jpa.review.ReviewJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@SessionAttributes({"TimeSheetKey"})
public class ApprovalPerformanceReviewCreateController {

    private final TimeSheetJpa timesheetJpa;
    private final ReviewJpa reviewJpa;

    @Autowired
    public ApprovalPerformanceReviewCreateController(TimeSheetJpa timesheetJpa, ReviewJpa reviewJpa) {
        this.timesheetJpa = timesheetJpa;
        this.reviewJpa = reviewJpa;
    }


    //       Review Form Displayed on reviewing Page
    @GetMapping("/newApproveReview/{id}")
    public String approveReviewDetails(@PathVariable("id") Long id,// Keep this after valid
                                       ApprovalReviewForm approvalReviewForm,
                                       Model model) {


        Optional<TimeSheet> ts = timesheetJpa.getByID(id);
        approvalReviewForm.setTimesheet(ts.get());

        model.addAttribute("ApprovalReviewDetails", approvalReviewForm);
        return "review_approval";

    }


    @PostMapping("/createReview")
    public String submitApproveReview(@Valid @ModelAttribute("ApprovalReviewDetails")
                                                  ApprovalReviewForm approvalReviewForm,
                                      BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()){
            model.addAttribute("ApprovalReviewDetails", approvalReviewForm);
            return "review_approval";
        }

        Review newReview = new Review(null,
                approvalReviewForm.getTimesheet(),
                true,
                false,
                approvalReviewForm.getMessage(),
                approvalReviewForm.getCommunication(),
                approvalReviewForm.getTechnical_skills(),
                approvalReviewForm.getQuality(),
                approvalReviewForm.getInitiative(),
                approvalReviewForm.getProductivity (),
                approvalReviewForm.getWorking_relationships()

        );

        reviewJpa.makeReview(newReview);

        log.info("Here is the review going into DB" + newReview.toString());

        return "redirect:/Reviews";
    }

}
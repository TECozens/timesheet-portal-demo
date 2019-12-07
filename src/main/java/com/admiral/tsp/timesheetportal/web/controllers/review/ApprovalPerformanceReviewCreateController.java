package com.admiral.tsp.timesheetportal.web.controllers.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.web.forms.review.ApprovalReviewForm;
import com.admiral.tsp.timesheetportal.data.jpa.review.ReviewJpa;
import com.admiral.tsp.timesheetportal.data.domain.Timesheet;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimesheetJpa;
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
@SessionAttributes({"TimesheetKey"})
public class ApprovalPerformanceReviewCreateController {

    @Autowired
    private TimesheetJpa timesheetJpa;
    @Autowired
    private ReviewJpa reviewJpa;


    //       Review Form Displayed on reviewing Page
    @GetMapping("/newApproveReview/{id}")
    public String approvereviewDetails(@PathVariable("id") Long id,// Keep this after valid
                                       ApprovalReviewForm approvalReviewForm,
                                       Model model) {
//
//        if (bindingResult.hasErrors()) {
//
//            log.error(bindingResult.toString());
//            log.error("review Form has binding errors");
            System.out.println();
            System.out.println();
            System.out.println(id);
            System.out.println(id);
            System.out.println();
            System.out.println();

            Optional<Timesheet> ts = timesheetJpa.getByID(id);
            approvalReviewForm.setTimesheet(ts.get());

            model.addAttribute("ApprovalreviewDetails", approvalReviewForm);
            return "review_approval";
//        }

////        if details are correct do the submit
//        return "redirect:/createReview/";
    }


    @PostMapping("/createReview")
    public String submitApproveReview(@Valid @ModelAttribute("ApprovalreviewDetails")  ApprovalReviewForm approvalReviewForm,
                                      BindingResult bindingResult, Model model) {
        String id_string =approvalReviewForm.getTimesheet().getId().toString();
        System.out.println(approvalReviewForm.toString());
        if (bindingResult.hasErrors()){
            model.addAttribute("ApprovalreviewDetails", approvalReviewForm);
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
                approvalReviewForm.getInitative(),
                approvalReviewForm.getProductivity (),
                approvalReviewForm.getWorking_relationships()

        );
        System.out.println(newReview.toString());

        reviewJpa.makeReview(newReview);

        log.debug("Here is the review going into DB" + newReview.toString());

        return "redirect:/Reviews";
    }

}
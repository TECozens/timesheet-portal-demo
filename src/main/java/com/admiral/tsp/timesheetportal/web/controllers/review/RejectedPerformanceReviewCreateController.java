package com.admiral.tsp.timesheetportal.web.controllers.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.data.jpa.timesheet.TimeSheetJpa;
import com.admiral.tsp.timesheetportal.web.forms.review.RejectionReviewForm;
import com.admiral.tsp.timesheetportal.data.jpa.review.ReviewJpa;
import com.admiral.tsp.timesheetportal.data.domain.TimeSheet;
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
public class RejectedPerformanceReviewCreateController {

    private final TimeSheetJpa timesheetJpa;
    private final ReviewJpa reviewJpa;

    @Autowired
    public RejectedPerformanceReviewCreateController(TimeSheetJpa timesheetJpa, ReviewJpa reviewJpa) {
        this.timesheetJpa = timesheetJpa;
        this.reviewJpa = reviewJpa;
    }


    //       Review Form Displayed on Contractor Page
    @PostMapping("/newRejectedReview/{id}")
    public String approveReviewDetails(@PathVariable("id") Long id,
                                       Model model) {



        Optional<TimeSheet> ts = timesheetJpa.getByID(id);
        RejectionReviewForm rejectionReviewForm = new RejectionReviewForm();

        rejectionReviewForm.setTimesheet(ts.get());

        model.addAttribute("RejectedReviewDetails", rejectionReviewForm);
        return "review_reject";
    }



    @PostMapping("/createRejectedReview")
    public String submitRejectReview(@Valid @ModelAttribute("RejectedReviewDetails")
                                                  RejectionReviewForm rejectionReviewForm,
                                      BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors().toString());

            model.addAttribute("RejectedReviewDetails", rejectionReviewForm);
            return "review_reject";
        }

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

        reviewJpa.makeReview(newReview);

        log.info("Here is the review going into DB" + newReview.toString());

        return "redirect:/Reviews";
    }

}
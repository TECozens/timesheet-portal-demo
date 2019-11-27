package com.admiral.tsp.timesheetportal.review.services;

import com.admiral.tsp.timesheetportal.review.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ReviewProcessor implements ReviewCreator {

    private ReviewRepoJPA reviewRepoJPA;

    @Autowired
    public ReviewProcessor(ReviewRepoJPA aRJPARepo) {
        reviewRepoJPA = aRJPARepo;
    }


    @Override
    @Transactional
    public Review makeReview(Review newReview) {
        Review updatedReview = reviewRepoJPA.saveAndFlush(newReview);
        log.info(updatedReview.toString());
        return updatedReview;
    }
}

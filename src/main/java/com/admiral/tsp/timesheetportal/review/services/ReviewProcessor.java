package com.admiral.tsp.timesheetportal.review.services;

import com.admiral.tsp.timesheetportal.review.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class ReviewProcessor implements ReviewCreator {

    private JpaRepository<Review, Long> reviewRepoJPA;

    @Autowired
    public ReviewProcessor(JpaRepository<Review, Long> aRJPARepo) {
        reviewRepoJPA = aRJPARepo;
    }


    @Override
    @Transactional
    public Review makeReview(Review newReview) {
        Review updatedReview = reviewRepoJPA.saveAndFlush(newReview);
        log.info(updatedReview.toString());
        return updatedReview;
    }

    @Override
    public Optional<Review> getByID(Long ID) {
        return reviewRepoJPA.findById(ID);
    }
}

package com.admiral.tsp.timesheetportal.review.services;

import com.admiral.tsp.timesheetportal.review.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReviewProcessor implements ReviewJpaRepo {

    // Autowired the generic referenced JPA repository inside the implemented Repo
    // This cleans up the layout of the code and bundles together the JPA interfaces
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewProcessor(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }


    @Override
    @Transactional
    public Review makeReview(Review newR) {
        Review updated = reviewRepository.saveAndFlush(newR);
        log.info(updated.toString());

        return updated;
    }

    @Override
    public Optional<Review> getByID(Integer ID) {
        return reviewRepository.getReviewById(ID);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.getAllReviews();
    }
}

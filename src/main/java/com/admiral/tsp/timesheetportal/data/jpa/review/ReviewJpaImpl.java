package com.admiral.tsp.timesheetportal.data.jpa.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import com.admiral.tsp.timesheetportal.services.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReviewJpaImpl implements ReviewJpa {

    // Autowired the review repository inside implementation
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewJpaImpl(ReviewRepository reviewRepository){
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

    @Transactional
    @Override
    public Optional<Review> updatePaid(Integer ID, Boolean paid) {

        System.out.println(reviewRepository.updateReviewStatus(ID, paid));
        return reviewRepository.getReviewById(1);
    }

    @Override
    public List<Review> getUnpaid() {
        return reviewRepository.getAllUnpaidReviews();
    }
}

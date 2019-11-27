package com.admiral.tsp.timesheetportal.review.services;

import com.admiral.tsp.timesheetportal.review.Review;

import java.util.Optional;

// Implemented by ReviewProcessor
public interface ReviewCreator {

    Review makeReview(Review reviewEvent);
    Optional<Review> getByID(Long ID);
}

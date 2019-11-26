package com.admiral.tsp.timesheetportal.review.services;

import com.admiral.tsp.timesheetportal.review.Review;

// Implemented by ReviewProcessor
public interface ReviewCreator {
    Review makeReview(Review reviewEvent);
}

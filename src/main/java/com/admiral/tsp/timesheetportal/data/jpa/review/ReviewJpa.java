package com.admiral.tsp.timesheetportal.data.jpa.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;

import java.util.List;
import java.util.Optional;

// Implemented by ReviewJpaImpl
public interface ReviewJpa {

    Review makeReview(Review item);
    Optional<Review> getByID(Integer ID);
    List<Review> getAll();
    Optional<Review> updatePaid(Integer ID, Boolean paid);
    List<Review> getUnpaid();


}

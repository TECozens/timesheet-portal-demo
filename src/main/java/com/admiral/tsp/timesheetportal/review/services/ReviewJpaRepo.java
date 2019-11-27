package com.admiral.tsp.timesheetportal.review.services;

import com.admiral.tsp.timesheetportal.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Implemented by ReviewProcessor
public interface ReviewJpaRepo {

    Review makeReview(Review item);
    Optional<Review> getByID(Long ID);
    List<Review> getAll();

}

package com.admiral.tsp.timesheetportal.review.services;

import com.admiral.tsp.timesheetportal.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Implemented by ReviewJpaImpl
public interface ReviewJpa {

    Review makeReview(Review item);
    Optional<Review> getByID(Integer ID);
    List<Review> getAll();


}

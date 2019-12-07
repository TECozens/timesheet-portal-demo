package com.admiral.tsp.timesheetportal.data.jpa.review;

import com.admiral.tsp.timesheetportal.data.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT review FROM Review review WHERE review.id =:id")
    Optional<Review> getReviewById(@Param("id") Integer id);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Review review SET review.paid = :paid WHERE review.id =:id")
    Integer updateReviewStatus(@Param("id") Integer id, @Param("paid") Boolean paid);

    @Query("SELECT review FROM Review review")
    List<Review> getAllReviews();

    @Query("SELECT review FROM Review review WHERE review.paid = FALSE")
    List<Review> getAllUnpaidReviews();
}

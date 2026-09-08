package com.trilheiros.trilheiros.trail.repository;

import com.trilheiros.trilheiros.trail.entity.TrailReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrailReviewRepository extends JpaRepository<TrailReview, Long> {

}

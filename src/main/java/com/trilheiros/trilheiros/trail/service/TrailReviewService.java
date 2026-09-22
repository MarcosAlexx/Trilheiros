package com.trilheiros.trilheiros.trail.service;

import com.trilheiros.trilheiros.trail.dto.TrailReviewRequestDTO;
import com.trilheiros.trilheiros.trail.dto.TrailReviewResponseDTO;
import com.trilheiros.trilheiros.trail.entity.TrailReview;
import com.trilheiros.trilheiros.trail.exception.TrailNotFoundException;
import com.trilheiros.trilheiros.trail.exception.TrailReviewNotFoundException;
import com.trilheiros.trilheiros.trail.repository.TrailRepository;
import com.trilheiros.trilheiros.trail.repository.TrailReviewRepository;
import com.trilheiros.trilheiros.user.exception.UserNotFoundException;
import com.trilheiros.trilheiros.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrailReviewService {

    final UserRepository userRepository;

    final TrailReviewRepository trailReviewRepository;

    final TrailRepository trailRepository;



    public TrailReviewResponseDTO createReview (TrailReviewRequestDTO trailReviewRequestDTO) {

        var user = userRepository.findById(trailReviewRequestDTO.userId())
                .orElseThrow(() -> new UserNotFoundException(trailReviewRequestDTO.userId()));

        var trail = trailRepository.findById(trailReviewRequestDTO.trailId())
                    .orElseThrow(() -> new TrailNotFoundException(trailReviewRequestDTO.trailId()));

        var newReview = trailReviewRepository.save(
                TrailReview.builder()
                    .trail(trail)
                    .user(user)
                    .rating(trailReviewRequestDTO.rating())
                    .comment(trailReviewRequestDTO.comment())
                    .createdAt(LocalDateTime.now())
                    .build()
        );

        return new TrailReviewResponseDTO(newReview.getId(), newReview.getTrail().getId(), newReview.getUser().getId(), newReview.getRating(), newReview.getComment(), newReview.getCreatedAt());

    }



    public List<TrailReviewResponseDTO> getReviewsByTrail(Long trailId) {
        var reviews = trailReviewRepository.findByTrailId(trailId);
        return reviews.stream().map(review -> new TrailReviewResponseDTO(review.getId(), review.getTrail().getId(), review.getUser().getId(), review.getRating(), review.getComment(), review.getCreatedAt())).collect(Collectors.toList());
    }



    public TrailReviewResponseDTO updateReview(Long id, TrailReviewRequestDTO trailReviewRequestDTO) {
       final var review = trailReviewRepository.findById(id)
                .orElseThrow(() -> new TrailReviewNotFoundException(id));

        review.setRating(trailReviewRequestDTO.rating());
        review.setComment(trailReviewRequestDTO.comment());

        var updatedReview = trailReviewRepository.save(review);

        return new TrailReviewResponseDTO(updatedReview.getId(), updatedReview.getTrail().getId(), updatedReview.getUser().getId(), updatedReview.getRating(), updatedReview.getComment(), updatedReview.getCreatedAt());
    }



    public void deleteReview(Long id) {
        trailReviewRepository.deleteById(id);
    }



}

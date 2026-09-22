package com.trilheiros.trilheiros.trail.controller;

import com.trilheiros.trilheiros.trail.dto.TrailReviewRequestDTO;
import com.trilheiros.trilheiros.trail.dto.TrailReviewResponseDTO;
import com.trilheiros.trilheiros.trail.service.TrailReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trail-reviews")
public class TrailReviewController {


    private final TrailReviewService trailReviewService;

    public TrailReviewController(TrailReviewService trailReviewService) {
        this.trailReviewService = trailReviewService;
    }


    @PostMapping("/create")
    public ResponseEntity<TrailReviewResponseDTO> createReview(@RequestBody TrailReviewRequestDTO trailReviewRequestDTO) {
        TrailReviewResponseDTO newReview = trailReviewService.createReview(trailReviewRequestDTO);
        return ResponseEntity.ok(newReview);
    }

    @GetMapping("/get-trail-Review/{trailId}")
    public ResponseEntity<List<TrailReviewResponseDTO>> getTrailReview(@PathVariable Long trailId) {
        List<TrailReviewResponseDTO> trailReview = trailReviewService.getReviewsByTrail(trailId);
        return ResponseEntity.ok(trailReview);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TrailReviewResponseDTO> updateReview(@PathVariable Long id, @RequestBody TrailReviewRequestDTO trailReviewRequestDTO) {
        TrailReviewResponseDTO updatedReview = trailReviewService.updateReview(id, trailReviewRequestDTO);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        trailReviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}

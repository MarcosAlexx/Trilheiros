package com.trilheiros.trilheiros.trail.controller;


import com.trilheiros.trilheiros.trail.dto.TrailRequestDTO;
import com.trilheiros.trilheiros.trail.dto.TrailResponseDTO;

import com.trilheiros.trilheiros.trail.service.TrailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trails")
public class TrailController {

    private final TrailService trailService;

    public TrailController(TrailService trailService) {
        this.trailService = trailService;
    }

    @PostMapping("/create")
    public ResponseEntity<TrailResponseDTO> createTrail (@RequestBody TrailRequestDTO trailDTO) {
        TrailResponseDTO newTrail = trailService.createTrail(trailDTO);
        return ResponseEntity.ok(newTrail);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TrailResponseDTO> getTrailById(@PathVariable Long id) {
        TrailResponseDTO trailResponseDTO = trailService.getTrailById(id);
        return ResponseEntity.ok(trailResponseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TrailResponseDTO> updateTrail(@PathVariable Long id, @RequestBody TrailRequestDTO trailRequestDTO) {
        TrailResponseDTO updatedTrail = trailService.updateTrail(id, trailRequestDTO);
        return ResponseEntity.ok(updatedTrail);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTrail(@PathVariable Long id) {
        trailService.deleteTrail(id);
        return ResponseEntity.noContent().build();
    }

}

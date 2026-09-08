package com.trilheiros.trilheiros.trail.service;


import com.trilheiros.trilheiros.trail.dto.TrailRequestDTO;
import com.trilheiros.trilheiros.trail.dto.TrailResponseDTO;
import com.trilheiros.trilheiros.trail.entity.Trail;
import com.trilheiros.trilheiros.trail.exception.TrailNotFoundException;
import com.trilheiros.trilheiros.trail.repository.TrailRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TrailService {

    public TrailService(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

    TrailRepository trailRepository;

    @Transactional
    public TrailResponseDTO createTrail(TrailRequestDTO trailRequestDTO) {

        Trail trail = Trail.builder()
                .name(trailRequestDTO.name())
                .description(trailRequestDTO.description())
                .city(trailRequestDTO.city())
                .state(trailRequestDTO.state())
                .difficulty(trailRequestDTO.difficulty())
                .distanceKm(trailRequestDTO.distanceKm())
                .durationHours(trailRequestDTO.durationHours())
                .longitude(trailRequestDTO.longitude())
                .latitude(trailRequestDTO.latitude())
                .contact(trailRequestDTO.contact())
                .build();

        Trail newTrail = this.trailRepository.save(trail);

        return new TrailResponseDTO(newTrail.getId(), newTrail.getName(), newTrail.getDescription(),
                newTrail.getCity(), newTrail.getState(), newTrail.getDifficulty(),
                newTrail.getDistanceKm(), newTrail.getDurationHours(), newTrail.getLongitude(),
                newTrail.getLatitude(), newTrail.getContact());
    }


    @Transactional
    public TrailResponseDTO getTrailById(Long id) {
        Trail trail = this.trailRepository.findById(id)
                .orElseThrow(() -> new TrailNotFoundException(id));
        return new TrailResponseDTO(trail.getId(), trail.getName(), trail.getDescription(), trail.getCity(), trail.getState(), trail.getDifficulty(), trail.getDistanceKm(), trail.getDurationHours(), trail.getLongitude(), trail.getLatitude(), trail.getContact());
    }


    @Transactional
    public TrailResponseDTO updateTrail(long id, TrailRequestDTO trailRequestDTO) {
        Trail trailAtt = this.trailRepository.findById(id)
                .orElseThrow(() -> new TrailNotFoundException(id));

            trailAtt.setName(trailRequestDTO.name());
            trailAtt.setDescription(trailRequestDTO.description());
            trailAtt.setCity(trailRequestDTO.city());
            trailAtt.setState(trailRequestDTO.state());
            trailAtt.setDifficulty(trailRequestDTO.difficulty());
            trailAtt.setDistanceKm(trailRequestDTO.distanceKm());
            trailAtt.setDurationHours(trailRequestDTO.durationHours());
            trailAtt.setLongitude(trailRequestDTO.longitude());
            trailAtt.setLatitude(trailRequestDTO.latitude());
            trailAtt.setContact(trailRequestDTO.contact());

        return new TrailResponseDTO(trailAtt.getId(), trailAtt.getName(), trailAtt.getDescription(), trailAtt.getCity(), trailAtt.getState(), trailAtt.getDifficulty(), trailAtt.getDistanceKm(), trailAtt.getDurationHours(), trailAtt.getLongitude(), trailAtt.getLatitude(), trailAtt.getContact());
    }

    @Transactional
    public void deleteTrail(long id) {
        Trail trail = trailRepository.findById(id)
                .orElseThrow(() -> new TrailNotFoundException(id));

        trailRepository.delete(trail);
    }








}

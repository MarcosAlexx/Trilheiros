package com.trilheiros.trilheiros.trail.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trails")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Trail {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "state", nullable = false, length = 100)
    private String state;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty", nullable = false)
    private Difficulty difficulty;

    @Column(name = "distance_km")
    private double distanceKm;

    @Column(name = "duration_hours", nullable = false)
    private double durationHours;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "contact", nullable = false, length = 100)
    private String contact;

}

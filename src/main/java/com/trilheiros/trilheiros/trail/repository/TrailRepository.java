package com.trilheiros.trilheiros.trail.repository;

import com.trilheiros.trilheiros.trail.entity.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrailRepository extends JpaRepository<Trail, Long> {
}

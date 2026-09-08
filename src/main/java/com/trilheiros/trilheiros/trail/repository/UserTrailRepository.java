package com.trilheiros.trilheiros.trail.repository;

import com.trilheiros.trilheiros.trail.entity.UserTrail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTrailRepository extends JpaRepository<UserTrail, Long> {

}

package com.trilheiros.trilheiros.trail.entity.entity;

import com.trilheiros.trilheiros.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_trails", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "trail_id"}))
public class UserTrail {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "trail_id", nullable = false)
    private Trail trail;

    @Column(name = "saved")
    private boolean saved;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "reminder")
    private boolean reminder;
}

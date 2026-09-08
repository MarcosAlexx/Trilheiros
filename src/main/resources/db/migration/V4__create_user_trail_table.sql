CREATE TABLE user_trails (
                             id BIGSERIAL PRIMARY KEY,

                             user_id BIGINT NOT NULL,
                             trail_id BIGINT NOT NULL,

                             saved BOOLEAN NOT NULL DEFAULT FALSE,
                             completed BOOLEAN NOT NULL DEFAULT FALSE,
                             completed_at TIMESTAMP,
                             reminder BOOLEAN NOT NULL DEFAULT FALSE,

                             CONSTRAINT fk_user_trails_user
                                 FOREIGN KEY (user_id) REFERENCES users(id),

                             CONSTRAINT fk_user_trails_trail
                                 FOREIGN KEY (trail_id) REFERENCES trails(id),

                             CONSTRAINT uk_user_trails_user_trail
                                 UNIQUE (user_id, trail_id)
);
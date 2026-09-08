CREATE TABLE trail_reviews (
                               id BIGSERIAL PRIMARY KEY,

                               trail_id BIGINT NOT NULL,
                               user_id BIGINT NOT NULL,

                               rating INTEGER NOT NULL,
                               comment VARCHAR(500),
                               created_at TIMESTAMP NOT NULL,

                               CONSTRAINT fk_trail_reviews_trail
                                   FOREIGN KEY (trail_id) REFERENCES trails(id),

                               CONSTRAINT fk_trail_reviews_user
                                   FOREIGN KEY (user_id) REFERENCES users(id),

                               CONSTRAINT ck_trail_reviews_rating
                                   CHECK (rating BETWEEN 1 AND 5),

                               CONSTRAINT uk_trail_reviews_user_trail
                                   UNIQUE (user_id, trail_id)
);
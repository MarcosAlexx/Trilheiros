CREATE TABLE trails (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description VARCHAR(255) NOT NULL,
                          city VARCHAR(100) NOT NULL,
                          state VARCHAR(100) NOT NULL,
                          location VARCHAR(100) NOT NULL,
                          difficulty VARCHAR(50) NOT NULL,
                          distanceKm DECIMAL(5,2) NOT NULL,
                          durationHours DECIMAL(5,2) NOT NULL,
                          longitude DECIMAL(10,7) NOT NULL,
                          latitude DECIMAL(10,7) NOT NULL,
                          contact VARCHAR(100) NOT NULL
);
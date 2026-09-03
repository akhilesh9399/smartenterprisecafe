CREATE TABLE towers
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tower_name  VARCHAR(100) NOT NULL,
    location_id BIGINT       NOT NULL,
    active      BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_tower_location
        FOREIGN KEY (location_id)
            REFERENCES locations (id)
);
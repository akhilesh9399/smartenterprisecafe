CREATE TABLE floors
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    floor_number INT    NOT NULL,
    tower_id     BIGINT NOT NULL,
    active       BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_floor_tower
        FOREIGN KEY (tower_id)
            REFERENCES towers (id)
);
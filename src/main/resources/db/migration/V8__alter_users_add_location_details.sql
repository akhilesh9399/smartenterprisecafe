ALTER TABLE users
    ADD COLUMN location_id BIGINT,
ADD COLUMN tower_id BIGINT,
ADD COLUMN floor_id BIGINT;

ALTER TABLE users
    ADD CONSTRAINT fk_user_location
        FOREIGN KEY (location_id)
            REFERENCES locations (id);

ALTER TABLE users
    ADD CONSTRAINT fk_user_tower
        FOREIGN KEY (tower_id)
            REFERENCES towers (id);

ALTER TABLE users
    ADD CONSTRAINT fk_user_floor
        FOREIGN KEY (floor_id)
            REFERENCES floors (id);
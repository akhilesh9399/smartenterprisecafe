CREATE TABLE kitchens
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    kitchen_name VARCHAR(100) NOT NULL,
    tower_id     BIGINT       NOT NULL UNIQUE,
    active       BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_kitchen_tower
        FOREIGN KEY (tower_id)
            REFERENCES towers (id)
);
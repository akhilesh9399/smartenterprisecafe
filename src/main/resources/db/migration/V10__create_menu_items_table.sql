CREATE TABLE menu_items
(

    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    item_name   VARCHAR(150)   NOT NULL,
    description VARCHAR(500),
    price       DECIMAL(10, 2) NOT NULL,
    available   BOOLEAN DEFAULT TRUE,
    category_id BIGINT         NOT NULL,
    CONSTRAINT fk_menu_category
        FOREIGN KEY (category_id)
            REFERENCES menu_categories (id)
);
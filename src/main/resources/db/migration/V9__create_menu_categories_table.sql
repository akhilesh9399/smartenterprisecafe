CREATE TABLE menu_categories
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    active  BOOLEAN DEFAULT TRUE
);
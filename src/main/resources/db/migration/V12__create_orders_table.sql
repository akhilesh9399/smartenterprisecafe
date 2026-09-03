CREATE TABLE orders
(

    id           BIGINT AUTO_INCREMENT PRIMARY KEY,

    order_number VARCHAR(50),
    employee_id  BIGINT NOT NULL,
    kitchen_id   BIGINT NOT NULL,
    status       VARCHAR(50),
    total_amount DECIMAL(10, 2),
    order_time   TIMESTAMP,
    CONSTRAINT fk_order_employee
        FOREIGN KEY (employee_id)
            REFERENCES users (id),

    CONSTRAINT fk_order_kitchen
        FOREIGN KEY (kitchen_id)
            REFERENCES kitchens (id)
);
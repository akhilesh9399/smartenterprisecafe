CREATE TABLE payments
(

    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    razorpay_order_id   VARCHAR(200),
    razorpay_payment_id VARCHAR(200),
    transaction_id      VARCHAR(200),
    amount              DECIMAL(10, 2),
    payment_mode        VARCHAR(50),
    payment_status      VARCHAR(50),
    payment_date        TIMESTAMP,
    order_id            BIGINT UNIQUE,
    CONSTRAINT fk_payment_order
        FOREIGN KEY (order_id)
            REFERENCES orders (id)

);
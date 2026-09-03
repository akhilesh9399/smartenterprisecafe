CREATE TABLE order_items
(

    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity     INT    NOT NULL,
    price        DECIMAL(10, 2),
    menu_item_id BIGINT NOT NULL,
    order_id     BIGINT NOT NULL,
    CONSTRAINT fk_orderitem_menuitem
        FOREIGN KEY (menu_item_id)
            REFERENCES menu_items (id),
    CONSTRAINT fk_orderitem_order
        FOREIGN KEY (order_id)
            REFERENCES orders (id)
);
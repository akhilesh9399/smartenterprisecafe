ALTER TABLE menu_items
    ADD COLUMN kitchen_id BIGINT;

ALTER TABLE menu_items
    ADD CONSTRAINT fk_menu_kitchen
        FOREIGN KEY (kitchen_id)
            REFERENCES kitchens (id);
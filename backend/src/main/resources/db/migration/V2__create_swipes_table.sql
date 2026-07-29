CREATE TABLE swipes (
    id BIGSERIAL PRIMARY KEY,
    restaurant_id BIGINT NOT NULL,
    direction VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_swipe_restaurant
        FOREIGN KEY (restaurant_id)
        REFERENCES restaurants(id)
);
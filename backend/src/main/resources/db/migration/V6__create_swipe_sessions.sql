CREATE TABLE swipe_sessions (

    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    status VARCHAR(20) NOT NULL,

    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_swipe_session_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);
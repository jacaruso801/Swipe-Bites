ALTER TABLE swipes
ADD COLUMN user_id BIGINT;

ALTER TABLE swipes
ADD CONSTRAINT fk_swipes_user
FOREIGN KEY (user_id)
REFERENCES users(id);
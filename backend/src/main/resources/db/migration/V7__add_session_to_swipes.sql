ALTER TABLE swipes
ADD COLUMN session_id BIGINT;

DELETE FROM swipes;

ALTER TABLE swipes
ALTER COLUMN session_id SET NOT NULL;

ALTER TABLE swipes
ADD CONSTRAINT fk_swipe_session
FOREIGN KEY (session_id)
REFERENCES swipe_sessions(id);
--CREATE TABLE users ( \
--	user_id serial PRIMARY KEY, \
--	username VARCHAR (50) UNIQUE NOT NULL,\
--);
--
--
--CREATE TABLE messages (
--
--	message_id serial PRIMARY KEY,
--	content VARCHAR (50) NOT NULL,
--	author id,
--	submitted_at timestamp,
--	FOREIGN KEY (message_id) REFERENCES users(user_id)
--)

CREATE TABLE migrationpurposes(
    username varchar(50)
)
--select username, messages.content from users inner join messages on users.user_id = messages.author;
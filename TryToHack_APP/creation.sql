DROP TABLE users CASCADE;
CREATE TABLE users (
userID numeric(3) check(userID > 0),
username varchar(20) NOT NULL,
password varchar(100) NOT NULL,

PRIMARY KEY (userID));


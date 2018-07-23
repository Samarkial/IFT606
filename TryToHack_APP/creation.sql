-- DROP TABLE users CASCADE;
CREATE TABLE users (
    userID SERIAL PRIMARY KEY,
    nom varchar(255) NOT NULL,
    prenom varchar(255) NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);

INSERT INTO users (nom, prenom, username, password)
VALUES ('Boisvert','Kevin','Kevin','qwerty');

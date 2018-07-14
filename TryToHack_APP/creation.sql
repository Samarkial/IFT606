-- DROP TABLE users CASCADE;
CREATE TABLE users (
    userID SERIAL PRIMARY KEY,
    nom varchar(255) NOT NULL,
    prenom varchar(255) NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    adresse varchar(255),
    codepostal varchar(6)
);

INSERT INTO users (nom, prenom, username, password, adresse, codepostal)
VALUES ('Boisvert','Kevin','Kevin','qwerty', '123 rue Université Sherbrooke','A1A1A1');

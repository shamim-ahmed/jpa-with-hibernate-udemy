CREATE TABLE Person
(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  location VARCHAR(255),
  birth_date TIMESTAMP
);

INSERT INTO PERSON (name, location, birth_date) VALUES ('Satoshi Nakamoto', 'Japan', SYSDATE());
INSERT INTO PERSON (name, location, birth_date) VALUES ('Elon Musk', 'USA', SYSDATE());
INSERT INTO PERSON (name, location, birth_date) VALUES ('Jeff Bezos', 'USA', SYSDATE());

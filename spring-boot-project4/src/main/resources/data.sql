create table Person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birthDate timestamp,
   primary key(id)
);

INSERT INTO Person (id, name, location, birthDate) VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO Person (id, name, location, birthDate) VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO Person (id, name, location, birthDate) VALUES(10003,  'Pieter', 'Amsterdam',sysdate());

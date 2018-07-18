create table Person(
  id integer not null,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp,
  primary key(id)
);


INSERT into Person(ID, NAME, location, birth_date) values (1, 'akshay', 'pune', sysdate());
INSERT into Person(ID, NAME, location, birth_date) values (2, 'amol', 'Hadpsar', sysdate());

INSERT into Employee(ID, NAME, location, birth_date) values (1, 'akshay', 'pune', sysdate());
INSERT into Employee(ID, NAME, location, birth_date) values (2, 'amol', 'Hadpsar', sysdate());


INSERT into Passport(ID, NUMBER) values (1, 'A12234');
INSERT into Passport(ID, NUMBER) values (2, 'B12234');


INSERT into Student(ID, NAME, PASSPORT_ID) values (1, 'Akshay', '1');
INSERT into Student(ID, NAME, PASSPORT_ID) values (2, 'Amol', '2');


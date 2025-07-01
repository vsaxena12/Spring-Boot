CREATE SEQUENCE IF NOT EXISTS person_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS Person (
    ID INT DEFAULT NEXT VALUE FOR person_seq PRIMARY KEY,
    NAME VARCHAR(255),
    EMAIL VARCHAR(255)
);

INSERT INTO Person(ID, NAME, EMAIL) VALUES (1001, 'Brittany', 'britt@gmail.com');
INSERT INTO Person(ID, NAME, EMAIL) VALUES (1002,'Varun', 'varun@gmail.com');
INSERT INTO Person(ID, NAME, EMAIL) VALUES (1003,'Ash','ash@gmail.com');
INSERT INTO Person(ID, NAME, EMAIL) VALUES (1004,'John','john@gmail.com');
INSERT INTO Person(ID, NAME, EMAIL) VALUES (1005,'Brad','brad@gmail.com');
INSERT INTO Person(ID, NAME, EMAIL) VALUES (1006,'Vasu','vasu@gmail.com');
CREATE TABLE member(
    id number(38) primary key,
    name varchar(256)
);



CREATE SEQUENCE member_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER member_bi
BEFORE INSERT ON member
FOR EACH ROW
BEGIN
    :new.id := member_seq.NEXTVAL;
END;
/
INSERT INTO member (name) VALUES ('spring');
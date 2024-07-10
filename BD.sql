CREATE TABLE EMPLOYEE (
    ID NUMBER PRIMARY KEY, 
    GENDER_ID NUMBER, 
    JOB_ID NUMBER, 
    NAME VARCHAR2(255) NOT NULL, 
    LAST_NAME VARCHAR2(255) NOT NULL, 
    BIRTHDATE DATE NOT NULL, 
    FOREIGN KEY (GENDER_ID) REFERENCES GENDER(ID), 
    FOREIGN KEY (JOB_ID) REFERENCES JOB(ID)
);

CREATE TABLE GENDER (
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(255) NOT NULL
);

CREATE TABLE JOB (
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(255) NOT NULL,
    SALARY NUMBER(9, 2) NOT NULL
);

CREATE TABLE WORKED (
    ID NUMBER PRIMARY KEY,
    EMPLOYEE_ID NUMBER,
    WORKED_HOURS NUMBER NOT NULL,
    WORKED_DATE DATE NOT NULL,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID)
);

select * from employee;
delete from employee where id = 351;

select * from job;

select * from worked;

insert into worked(id, employee_id, worked_hours, worked_date) 
values (1, 253, 10, TO_DATE('2024-07-05', 'YYYY-MM-DD'));

insert into worked(id, employee_id, worked_hours, worked_date) 
values (2, 254, 10, TO_DATE('2024-07-05', 'YYYY-MM-DD'));

insert into worked(id, employee_id, worked_hours, worked_date) 
values (3, 255, 12, TO_DATE('2024-07-05', 'YYYY-MM-DD'));

update worked set worked_hours = 100 where id = 1;

delete from worked where id = 3;
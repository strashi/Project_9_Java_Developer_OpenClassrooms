DROP TABLE IF EXISTS patient ;

CREATE TABLE patient
(
    patient_id      INT primary key AUTO_INCREMENT,
    first_name      VARCHAR(10) ,
    last_name       VARCHAR(50),
    dob             DATE,
    sex             VARCHAR(10) ,
    address         VARCHAR(50) ,
    phone           VARCHAR(20)
);
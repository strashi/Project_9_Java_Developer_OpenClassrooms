CREATE DATABASE IF NOT EXISTS `mediscreenDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mediscreenDB` ;

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
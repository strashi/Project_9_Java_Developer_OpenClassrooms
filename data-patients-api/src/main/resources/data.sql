/*INSERT INTO patient (patient_Id , first_Name ,family , given , dob , sex , address , phone )
VALUES (0, 'Astrid', 'A', 'prod', '1990-06-15' , 'F' , '4 rue nationale' , '885-9554-85');

INSERT INTO patient (PATIENT_ID , FIRST_NAME ,FAMILY ,GIVEN ,DOB , SEX , ADDRESS , PHONE )
VALUES (1, 'Bernard', 'B', 'prod', '1970-08-30' , 'M' , '35 rue bonaparte' , '932-8334-49');

INSERT INTO patient (PATIENT_ID , FIRST_NAME ,FAMILY ,GIVEN ,DOB , SEX , ADDRESS , PHONE )
VALUES (2, 'Chloé', 'C', 'prod', '1981-12-02' , 'F' , '12 allée des coquelicots' , '221-9244-95');

INSERT INTO patient (PATIENT_ID , FIRST_NAME ,FAMILY ,GIVEN ,DOB , SEX , ADDRESS , PHONE )
VALUES (3, 'Denis', 'D', 'prod', '1957-01-10' , 'M' , '2 av principale' , '445-9324-85');*/

INSERT INTO patient ( first_Name ,last_name , dob , sex , address , phone )
VALUES ( 'Astrid', 'A', '1990-06-15' , 'F' , '4 rue nationale' , '885-9554-85');

INSERT INTO patient ( FIRST_NAME ,last_name ,DOB , SEX , ADDRESS , PHONE )
VALUES ( 'Bernard', 'B', '1970-08-30' , 'M' , '35 rue bonaparte' , '932-8334-49');

INSERT INTO patient ( FIRST_NAME ,last_name ,DOB , SEX , ADDRESS , PHONE )
VALUES ( 'Chloé', 'C', '1981-12-02' , 'F' , '12 allée des coquelicots' , '221-9244-95');

INSERT INTO patient ( FIRST_NAME ,last_name ,DOB , SEX , ADDRESS , PHONE )
VALUES ( 'Denis', 'D', '1957-01-10' , 'M' , '2 av principale' , '445-9324-85');

UPDATE `hibernate_sequence` SET `next_val`=5 WHERE 1
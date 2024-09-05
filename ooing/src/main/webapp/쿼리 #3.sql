CREATE TABLE LOTTO_INFO(
LT_NUM INT AUTO_INCREMENT PRIMARY KEY,
LT_TIME TIMESTAMP NOT NULL,
LT_NUMBER_1 TINYINT NOT NULL,
LT_NUMBER_2 TINYINT NOT NULL,
LT_NUMBER_3 TINYINT NOT NULL,
LT_NUMBER_4 TINYINT NOT NULL,
LT_NUMBER_5 TINYINT NOT NULL,
LT_NUMBER_6 TINYINT NOT NULL,
LT_NUMBER_B TINYINT NOT NULL
);

SELECT * FROM LOTTO_INFO;



INSERT INTO LOTTO_INFO( LT_TIME, LT_NUMBER_1, LT_NUMBER_2, LT_NUMBER_3, LT_NUMBER_4, LT_NUMBER_5, LT_NUMBER_6, LT_NUMBER_B) 
VALUES(NOW(),1,2,3,4,5,6,7);
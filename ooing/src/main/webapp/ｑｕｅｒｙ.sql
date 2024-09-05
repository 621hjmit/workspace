-- 테이블 생성
 CREATE TABLE USER_INFO(
 UI_NUM int AUTO_INCREMENT PRIMARY KEY,
 UI_PWD VARCHAR(100) NOT NULL,
 UI_NAME VARCHAR(20) NOT null,
 UI_ID  VARCHAR(20) NOT null,
 CREDAT CHAR(8) NOT null,
 CRETIM CHAR(8) NOT NULL
);

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
-- 데이터 삽입
-- INSERT INTO USER_INFO(UI_NAME, UI_ID, CREDAT , CRETIM )VALUES('홍길동', 'TEST' , '20240827' , '1999990');

-- SELECT * FROM USER_INFO;
-- INSERT INTO USER_INFO(UI_NAME, UI_ID, CREDAT , CRETIM ) VALUES('동동','DD',DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s'));
-- DESC user_info;
-- SELECT DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s');


-- ALTER TABLE USER_INFO ADD COLUMN UI_PWD VARCHAR(100) AFTER UI_ID;
DESC user_info;

ALTER TABLE USER_INFO ADD UI_GENDER CHAR(1);

DROP TABLE user_info;

CREATE TABLE user_info(
	UI_NUM INT AUTO_INCREMENT PRIMARY KEY,
	UI_NAME VARCHAR(30) NOT NULL,
	UI_ID VARCHAR(30) NOT NULL,
	UI_PWD VARCHAR(50) NOT NULL,
	UI_GENDER CHAR(1) NOT NULL,
	UI_BIRTH CHAR(8) NOT NULL,
	UI_HOBBY VARCHAR(100),
	UI_DESC TEXT,
	CREDAT CHAR(8) DEFAULT DATE_FORMAT(NOW(), '%Y%m%d'),
	CRETIM CHAR(6) DEFAULT DATE_FORMAT(NOW(), '%H%i%s')
);

INSERT INTO user_info (
UI_NAME, UI_ID, UI_PWD, UI_GENDER,
UI_BIRTH, UI_HOBBY, UI_DESC)
VALUES(
'테스트', 'test', 't1234', '1',
'20001011','자전거, 영화','안녕하세요');

SELECT UI_NUM, UI_NAME, UI_ID, UI_PWD
UI_GENDER, UI_BIRTH, UI_HOBBY, UI_DESC,
CREDAT, CRETIM
FROM user_info;

UPDATE USER_INFO
SET UI_NAME='하늘이야',
UI_ID='sky1',
UI_GENDER='1',
UI_BIRTH='19890621',
UI_HOBBY='자전거,영화',
UI_DESC='ㅁㄴㅇㄹ'
,UI_PWD='1234'
WHERE UI_NUM=1;


CREATE TABLE CAR_INFO(
CI_NUM INT AUTO_INCREMENT PRIMARY KEY,
CI_NAME VARCHAR(30) NOT NULL,
CI_YEAR CHAR(4) NOT NULL
);

SELECT * FROM CAR_INFO;

INSERT INTO CAR_INFO (CI_NAME, CI_YEAR) VALUES ('소나타','2024');

UPDATE CAR_INFO SET CI_NAME = 'YG소나타', CI_YEAR='2023' WHERE CI_NUM = 1;

SELECT CI_NUM, CI_NAME, CI_YEAR FROM CAR_INFO;

DELETE FROM CAR_INFO WHERE CI_NUM = 1;

COMMIT;
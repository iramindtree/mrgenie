CREATE TABLE SYSTEM_DATE  (
SYSTEM_DATE DATETIME NOT NULL
)

TRUNCATE TABLE SYSTEM_DATE;
INSERT INTO SYSTEM_DATE ('2017-02-18 12:00:00');
COMMIT;

CREATE TABLE CUSTOMER_INFO (
CUST_ID		VARCHAR(15) NOT NULL PRIMARY KEY,
CUST_FNAME	VARCHAR(25) NOT NULL,
CUST_LNAME	VARCHAR(45) NOT NULL,
CUST_EMAIL	VARCHAR(45),
CUST_GENDER	VARCHAR(1) NOT NULL DEFAULT 'M',
CUST_CREATED	TIMESTAMP	NOT NULL DEFAULT CURRENT_TIMESTAMP

); 


INSERT INTO CUSTOMER_INFO (CUST_ID, CUST_FNAME, CUST_LNAME, CUST_EMAIL, CUST_GENDER) VALUES 
('9663175755', 'VIJENDRA', 'LAKSHMANA RAO', 'M1031960@MINDTREE.COM', 'M'),
('9741657696', 'AMIT', 'LELE', 'AMIT.LELE@MINDTREE.COM','M'),
('6475394765', 'MIKE', 'SUN', 'MIKE.SUN@MINDTREE.COM', 'M');

COMMIT;



CREATE TABLE RESERVATION_INFO (
  RESERVATION_CONF_NO INT NOT NULL,
  ARRIVAL_DATE DATE NOT NULL,
  CHECKIN_DATETIME DATETIME NOT NULL,
  CHECKOUT_DATETIME DATETIME NOT NULL,
  CUSTOMER_ID VARCHAR(45) NOT NULL,
  PRIMARY KEY (RESERVATION_CONF_NO));
  
  INSERT INTO RESERVATION_INFO (RESERVATION_CONF_NO, ARRIVAL_DATE, CHECKIN_DATETIME, CHECKOUT_DATETIME, CUSTOMER_ID) VALUES ('86904389', '2017-02-18', '2017-02-18', '2017-02-21 12:00:00', '9741657696');

  COMMIT;
  
  
  CREATE TABLE PMS_RESERVATION_INFO (
  RESERVATION_CONF_NO INT NOT NULL,
  ROOM_NUMBER VARCHAR(45) NOT NULL,
  PROPERTY_ID VARCHAR(45) NOT NULL,
  PRIMARY KEY (RESERVATION_CONF_NO));
  
  	INSERT INTO PMS_RESERVATION_INFO (RESERVATION_CONF_NO, ROOM_NUMBER, PROPERTY_ID) VALUES ('86904389', '1411', '1');
	INSERT INTO PMS_RESERVATION_INFO (RESERVATION_CONF_NO, ROOM_NUMBER, PROPERTY_ID) VALUES ('19736383', '12345', '2');
	INSERT INTO PMS_RESERVATION_INFO (RESERVATION_CONF_NO, ROOM_NUMBER, PROPERTY_ID) VALUES ('201702689', '2234', '3');
	COMMIT;
  
  
  
  CREATE TABLE PROPERTY_INFO (
  PROPERTY_ID INT NOT NULL,
  PROPERTY_CODE VARCHAR(45) NOT NULL,
  PROPERTY_NAME VARCHAR(45) NOT NULL,
  PROPERTY_GEO_COORDINATES VARCHAR(45) NOT NULL,
  PRIMARY KEY (PROPERTY_ID));
  
  	INSERT INTO PROPERTY_INFO (PROPERTY_ID, PROPERTY_CODE, PROPERTY_NAME, PROPERTY_GEO_COORDINATES) VALUES ('1', 'NYCR', 'NYC RESIDENCE', '40.7586115,-73.98624749999999');
	INSERT INTO PROPERTY_INFO (PROPERTY_ID, PROPERTY_CODE, PROPERTY_NAME, PROPERTY_GEO_COORDINATES) VALUES ('2', 'GBRI', 'GAITHERSBURG RESIDENCE', '39.12764629999999,-77.17964899999998');
	INSERT INTO PROPERTY_INFO (PROPERTY_ID, PROPERTY_CODE, PROPERTY_NAME, PROPERTY_GEO_COORDINATES) VALUES ('3', 'BLRWF', 'BENGALURU HOTEL WHITEFIELD', '12.979324,77.72796399999993');
	COMMIT;

  
  CREATE TABLE DEPARTMENT_ACTION (
  DEPARTMENT_CODE VARCHAR(45) NOT NULL,
  ACTION_CODE VARCHAR(45) NOT NULL,
  PRIMARY KEY (DEPARTMENT_CODE, ACTION_CODE));
  
  
  CREATE TABLE PROPERTY_AMENITIES (
  AMENITY_ID INT NOT NULL,
  PROPERTY_ID INT NOT NULL,
  AMENITY_NAME VARCHAR(45) NOT NULL,
  OPERATING_DAYS VARCHAR(45) NOT NULL,
  OPEN_TIME TIME NOT NULL,
  CLOSING_TIME TIME NOT NULL,
  PRIMARY KEY (AMENITY_ID));
  
  	INSERT INTO PROPERTY_AMENITIES (AMENITY_ID, PROPERTY_ID, AMENITY_NAME, OPERATING_DAYS, OPEN_TIME, CLOSING_TIME) VALUES ('1', '1', 'POOL', '1,2,3,4,5,6,7', '08:00', '18:00');
	INSERT INTO PROPERTY_AMENITIES (AMENITY_ID, PROPERTY_ID, AMENITY_NAME, OPERATING_DAYS, OPEN_TIME, CLOSING_TIME) VALUES ('2', '1', 'GYM', '1,2,3,4,5,6,7', '05:00', '22:00');
	INSERT INTO PROPERTY_AMENITIES (AMENITY_ID, PROPERTY_ID, AMENITY_NAME, OPERATING_DAYS, OPEN_TIME, CLOSING_TIME) VALUES ('3', '2', 'POOL', '1,2,3,4,5,6,7', '07:00', '19:00');
	COMMIT

  
  CREATE TABLE CONSUMPTION_INFO (
  CONSUMPTION_ID INT NOT NULL,
  RESERVATION_CONF_NO VARCHAR(45) NOT NULL,
  CONSUMPTION_DATE DATE NOT NULL,
  CONSUMPTION_AMOUNT DOUBLE NOT NULL,
  PRIMARY KEY (CONSUMPTION_ID));

  
  CREATE TABLE SERVICE_REQUEST (
  SERVICE_REQUEST_ID VARCHAR(45) NOT NULL,
  CUSTOMER_ID VARCHAR(45) NOT NULL,
  PROPERTY_ID INT NOT NULL,
  ROOM_NO VARCHAR(45) NOT NULL,
  DEPARTMENT_ID VARCHAR(45) NOT NULL,
  REQUEST_DESC VARCHAR(200) NOT NULL,
  REQUEST_STATUS VARCHAR(45) NOT NULL,
  EXECUTION_TIME DATETIME NULL,
  PRIMARY KEY (SERVICE_REQUEST_ID));
  
  CREATE TABLE CUSTOMER_DEVICE_INFO (
  DEVICE_ID VARCHAR(45) NOT NULL,
  CUSTOMER_ID VARCHAR(45) NOT NULL,
  RESERVATION_CONF_NO INT NOT NULL,
  PRIMARY KEY (DEVICE_ID));
  
  
  	INSERT INTO CUSTOMER_DEVICE_INFO (DEVICE_ID, CUSTOMER_ID, RESERVATION_CONF_NO) VALUES ('353326064926472', '9741657696', '86904389');
	INSERT INTO CUSTOMER_DEVICE_INFO (DEVICE_ID, CUSTOMER_ID, RESERVATION_CONF_NO) VALUES ('353326064926480', '9741657696', '86904389');
	INSERT INTO CUSTOMER_DEVICE_INFO (DEVICE_ID, CUSTOMER_ID, RESERVATION_CONF_NO) VALUES ('863122032995605', '9663175755', '19736383');
	INSERT INTO CUSTOMER_DEVICE_INFO (DEVICE_ID, CUSTOMER_ID, RESERVATION_CONF_NO) VALUES ('863122032995613', '9663175755', '19736383');
	INSERT INTO CUSTOMER_DEVICE_INFO (DEVICE_ID, CUSTOMER_ID, RESERVATION_CONF_NO) VALUES ('869100020602312', '9741657696', '86904389');
	INSERT INTO CUSTOMER_DEVICE_INFO (DEVICE_ID, CUSTOMER_ID, RESERVATION_CONF_NO) VALUES ('869100020632319', '9741657696', '86904389');
	
	COMMIT;
  
  CREATE TABLE CUSTOMER_PROFILE_INFO(
	CUSTOMER_ID VARCHAR(15) NOT NULL PRIMARY KEY,
	CUSTOMER_PREFERECE_TYPE	VARCHAR(25) NOT NULL,
	CUSTOMER_PREFERENCE_SUBTYPE	VARCHAR(25) NOT NULL,
	CUSTOMER_MILK_REFERENCE	VARCHAR(25)	NOT NULL,
	CUSTOMER_SUGER_LEVEL_PREFERENCE	VARCHAR(25)	NOT NULL,
	CUSTOMER_TEMPERATURE_PREFERENCE	VARCHAR(25)	NOT NULL
); 

INSERT INTO CUSTOMER_PROFILE_INFO (CUSTOMER_ID, CUSTOMER_PREFERECE_TYPE, CUSTOMER_PREFERENCE_SUBTYPE, CUSTOMER_MILK_REFERENCE, CUSTOMER_SUGER_LEVEL_PREFERENCE, CUSTOMER_TEMPERATURE_PREFERENCE) VALUES ('9741657696', 'BEVERAGE', 'COFFEE', 'SKIM', '2 SPOONS', 'EXTRA HOT');
INSERT INTO CUSTOMER_PROFILE_INFO (CUSTOMER_ID, CUSTOMER_PREFERECE_TYPE, CUSTOMER_PREFERENCE_SUBTYPE, CUSTOMER_MILK_REFERENCE, CUSTOMER_SUGER_LEVEL_PREFERENCE, CUSTOMER_TEMPERATURE_PREFERENCE) VALUES ('9663175755', 'BEVERAGE', 'COFFEE', 'FLAT', '3 SPOONS', 'NORMAL');
INSERT INTO CUSTOMER_PROFILE_INFO (CUSTOMER_ID, CUSTOMER_PREFERECE_TYPE, CUSTOMER_PREFERENCE_SUBTYPE, CUSTOMER_MILK_REFERENCE, CUSTOMER_SUGER_LEVEL_PREFERENCE, CUSTOMER_TEMPERATURE_PREFERENCE) VALUES ('6475394765', 'BEVERAGE', 'TEA', 'NO', '1 SPOON', 'NORMAL');

CREATE TABLE master_date (
  master_date datetime NOT NULL,
  PRIMARY KEY (master_date)
);

CREATE TABLE abandon_interaction (
  Customer_ID varchar(45) NOT NULL,
  Interaction_ID int(11) NOT NULL AUTO_INCREMENT,
  Iteraction_type varchar(45) NOT NULL,
  Interaction_source varchar(45) NOT NULL,
  Interaction_date_timestamp datetime NOT NULL,
  destination_city varchar(45) NOT NULL,
  check_in_date datetime NOT NULL,
  check_out_date datetime NOT NULL,
  PRIMARY KEY (Interaction_ID)
);

  
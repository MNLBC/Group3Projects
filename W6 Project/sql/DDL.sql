--USERS TABLE (UNABLE TO CREATE USER TABLE - USER IS  RESERVED)
CREATE TABLE USERS(
	 USER_ID        NUMBER(15)   NOT NULL PRIMARY KEY
	,USERNAME       VARCHAR(40)  UNIQUE NOT NULL 
	,USER_PASSWORD  VARCHAR(100) NOT NULL
	,FULL_NAME      VARCHAR(60)  NOT NULL
	,EMAIL          VARCHAR(50)  NOT NULL
	,ADDRESS        VARCHAR(225) NOT NULL
	,MOBILE_NUMBER  VARCHAR(15) 
	,USER_ROLE      VARCHAR(8)   NOT NULL
	,IS_BLACKLISTED VARCHAR(3)
);

--DROP TABLE USERS;
/*
 SEQUENCE AND TRIGGER FOR USERS TABLE
*/

CREATE SEQUENCE USER_ID_SEQ START WITH 1000000001 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER USER_ID_TRIG
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
IF :new.USER_ID IS NULL THEN
SELECT USER_ID_SEQ.nextval INTO :new.USER_ID FROM DUAL;
END IF;
END;

--DROP SEQUENCE USER_UUID_SEQ;
--DROP TRIGGER USER_ID_TRIG;
/*
INSERT INTO USERS(    
 USERNAME      
,USER_PASSWORD 
,FULL_NAME     
,EMAIL         
,ADDRESS       
,MOBILE_NUMBER 
,USER_ROLE     
,USER_BALANCE  )
VALUES('brionse','redhat','Sebastian Briones', 'sebastian.briones@oocl.com', 'Gladiola, Laguna', '09876543211', 'customer', 100000.00);
*/
--PRODUCTS TABLE
CREATE TABLE PRODUCT(
    PRODUCT_ID             NUMBER(15)   NOT NULL PRIMARY KEY
   ,PRODUCT_NAME           VARCHAR(80)  UNIQUE NOT NULL
   ,PRODUCT_DESCRIPTION    VARCHAR(220) NOT NULL
   ,PRODUCT_PRICE          NUMBER(10,2) NOT NULL
   ,PRODUCT_STOCK_QUANTITY NUMBER(8)    NOT NULL
   ,PRODUCT_IMAGE_PATH     VARCHAR(220) NOT NULL
);

--DROP TABLE PRODUCT;
/*
 SEQUENCE AND TRIGGER FOR PRODUCT TABLE
*/

CREATE SEQUENCE PRODUCT_ID_SEQ START WITH 2000000001 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER PRODUCT_ID_TRIG
BEFORE INSERT ON PRODUCT
FOR EACH ROW
BEGIN
IF :new.PRODUCT_ID IS NULL THEN
SELECT PRODUCT_ID_SEQ.nextval INTO :new.PRODUCT_ID FROM DUAL;
END IF;
END;

--DROP SEQUENCE PRODUCT_ID_SEQ;
--DROP TRIGGER PRODUCT_ID_TRIG;

--ORDERS TABLE
CREATE TABLE ORDERS(
   ORDER_ID      NUMBER(15)   NOT NULL PRIMARY KEY
  ,USER_ID       NUMBER(15)   NOT NULL
  ,ORDER_DATE    VARCHAR(18)  NOT NULL
  ,TOTAL_COST    NUMBER(10,2) NOT NULL
  ,ORDER_STATUS  VARCHAR(20)  NOT NULL
);

ALTER TABLE ORDERS ADD CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID);
/*
 SEQUENCE AND TRIGGER FOR ORDER TABLE
*/

CREATE SEQUENCE ORDER_ID_SEQ START WITH 3000000001 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ORDER_ID_TRIG
BEFORE INSERT ON ORDERS
FOR EACH ROW
BEGIN
IF :new.ORDER_ID IS NULL THEN
SELECT ORDER_ID_SEQ.nextval INTO :new.ORDER_ID FROM DUAL;
END IF;
END;

--DROP SEQUENCE ORDER_ID_SEQ;
--DROP TRIGGER ORDER_ID_TRIG;

--ORDER ITEM TABLE
CREATE TABLE ORDER_ITEM(
    ORDER_ITEM_ID  NUMBER(15)   NOT NULL PRIMARY KEY
   ,ORDER_ID       NUMBER(15)   NOT NULL
   ,PRODUCT_ID     NUMBER(15)   NOT NULL
   ,QUANTITY       NUMBER(4)    NOT NULL
   ,ORDERED_PRICE  NUMBER(10,2) NOT NULL
);

ALTER TABLE ORDER_ITEM ADD CONSTRAINT FK_ORDER_ID FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ORDER_ID);
ALTER TABLE ORDER_ITEM ADD CONSTRAINT FK_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID);

/*
 SEQUENCE AND TRIGGER FOR ORDER_ITEM TABLE
*/

CREATE SEQUENCE ORDER_ITEM_ID_SEQ START WITH 3000000001 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER ORDER_ITEM_ID_TRIG
BEFORE INSERT ON ORDER_ITEM
FOR EACH ROW
BEGIN
IF :new.ORDER_ITEM_ID IS NULL THEN
SELECT ORDER_ITEM_ID_SEQ.nextval INTO :new.ORDER_ITEM_ID FROM DUAL;
END IF;
END;


--DROP SEQUENCE ORDER_ID_SEQ;
--DROP TRIGGER ORDER_ID_TRIG;

ALTER TABLE USERS DROP COLUMN USER_BALANCE;
ALTER TABLE USERS ADD (IS_BLACKLISTED VARCHAR(3));


/*
 MEMBERSHIP_TYPE TABLE
*/
CREATE TABLE MEMBERSHIP_TYPE(
   MEMBERSHIP_TYPE_ID   NUMBER(15)  NOT NULL PRIMARY KEY
  ,MEMBERSHIP_TYPE_NAME VARCHAR(50) NOT NULL
  ,DISCOUNT_RATE        NUMBER(2)   NOT NULL
);
/*
  MEMBER SHIP TYPES
*/
INSERT INTO MEMBERSHIP_TYPE(MEMBERSHIP_TYPE_NAME,DISCOUNT_RATE) VALUES('REGULAR',0);
INSERT INTO MEMBERSHIP_TYPE(MEMBERSHIP_TYPE_NAME,DISCOUNT_RATE) VALUES('MEMBER',10);
INSERT INTO MEMBERSHIP_TYPE(MEMBERSHIP_TYPE_NAME,DISCOUNT_RATE) VALUES('VIP',20);
INSERT INTO MEMBERSHIP_TYPE(MEMBERSHIP_TYPE_NAME,DISCOUNT_RATE) VALUES('STUDENT',20);
INSERT INTO MEMBERSHIP_TYPE(MEMBERSHIP_TYPE_NAME,DISCOUNT_RATE) VALUES('SENIOR',20);

/*
 USER MEMBERSHIP ASSOCIATION TABLE
*/
CREATE TABLE USER_MEMBERSHIP_ASSN(
   USER_MEMBERSHIP_ID              NUMBER(15)   NOT NULL PRIMARY KEY
  ,USER_ID       		           NUMBER(15)   NOT NULL
  ,MEMBERSHIP_TYPE_ID              NUMBER(15)   NOT NULL
  ,REQUESTED_MEMBERSHIP_TYPE_ID    NUMBER(15)   
);

ALTER TABLE USER_MEMBERSHIP_ASSN ADD (IS_FOR_APPROVAL     NUMBER(1),
                                      IS_REQUEST_APPROVED NUMBER(1));


ALTER TABLE USER_MEMBERSHIP_ASSN ADD CONSTRAINT FK_MEMBERSHIP_TYPE_ID FOREIGN KEY (MEMBERSHIP_TYPE_ID) REFERENCES MEMBERSHIP_TYPE (MEMBERSHIP_TYPE_ID);
ALTER TABLE USER_MEMBERSHIP_ASSN ADD CONSTRAINT FK_MEMBERSHIP_TYPE_ID FOREIGN KEY (MEMBERSHIP_TYPE_ID) REFERENCES MEMBERSHIP_TYPE (MEMBERSHIP_TYPE_ID);
ALTER TABLE USER_MEMBERSHIP_ASSN ADD CONSTRAINT FK_MEMBERSHIP_USER_ID FOREIGN KEY (USER_ID)            REFERENCES USERS (USER_ID);

/*
 SEQUENCE AND TRIGGER FOR MEMBERSHIP_TYPE TABLE
*/
CREATE SEQUENCE MEMBERSHIP_TYPE_ID_SEQ START WITH 5000000001 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER MEMBERSHIP_TYPE_ID_TRIG
BEFORE INSERT ON MEMBERSHIP_TYPE
FOR EACH ROW
BEGIN
IF :new.MEMBERSHIP_TYPE_ID IS NULL THEN
SELECT MEMBERSHIP_TYPE_ID_SEQ.nextval INTO :new.MEMBERSHIP_TYPE_ID FROM DUAL;
END IF;
END;



--DROP SEQUENCE MEMBERSHIP_TYPE_ID_SEQ;
--DROP TRIGGER MEMBERSHIP_TYPE_ID_TRIG;

/*
 SEQUENCE AND TRIGGER FOR MEMBERSHIP_TYPE TABLE
*/
CREATE SEQUENCE USER_MEMBERSHIP_ASSN_ID_SEQ START WITH 6000000001 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER USER_MEMBERSHIP_ASSN_ID_TRIG
BEFORE INSERT ON USER_MEMBERSHIP_ASSN
FOR EACH ROW
BEGIN
IF :new.USER_MEMBERSHIP_ID IS NULL THEN
SELECT USER_MEMBERSHIP_ASSN_ID_SEQ.nextval INTO :new.USER_MEMBERSHIP_ID FROM DUAL;
END IF;
END;
--DROP SEQUENCE USER_MEMBERSHIP_ASSN_ID_SEQ;
--DROP TRIGGER USER_MEMBERSHIP_ASSN_ID_TRIG;

/*
	CART_ITEM TABLE
*/
CREATE TABLE CART_ITEM(
   CART_ITEM_ID            NUMBER(15)          NOT NULL PRIMARY KEY
  ,USER_ID       		   NUMBER(15)          NOT NULL
  ,PRODUCT_ID              NUMBER(15)          NOT NULL
  ,PRODUCT_NAME            VARCHAR(100)        NOT NULL
  ,PRODUCT_DESCRIPTION     VARCHAR(220)        NOT NULL
  ,QUANTITY                NUMBER(8)           NOT NULL
  ,PRODUCT_PRICE           NUMBER(10,2)        NOT NULL
  ,PRODUCT_IMAGE_PATH      VARCHAR(220)        NOT NULL
);

/*
 SEQUENCE AND TRIGGER FOR CART_ITEM TABLE
*/
CREATE SEQUENCE CART_ITEM_ID_SEQ START WITH 7000000001 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER CART_ITEM_ID_TRIG
BEFORE INSERT ON CART_ITEM
FOR EACH ROW
BEGIN
IF :new.CART_ITEM_ID IS NULL THEN
SELECT CART_ITEM_ID_SEQ.nextval INTO :new.CART_ITEM_ID FROM DUAL;
END IF;
END;
--DROP SEQUENCE CART_ITEM_ID_SEQ;
--DROP TRIGGER CART_ITEM_ID_TRIG;


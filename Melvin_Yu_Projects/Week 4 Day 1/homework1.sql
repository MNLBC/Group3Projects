/** Homework Week 4 Day 1 **/

--user can have many orders
--one order has many items;
--users - user_id PK, first_name, last_name, date_created
--orders - order_id PK , user_id FK
--order_items - item_id, item_name,item_details, order_id;


create table users(user_id number(11) not null, first_name varchar(100), last_name varchar(100), date_created date, primary key(user_id));

create table orders(order_id number(11) not null, user_id number(11) not null, PRIMARY KEY (order_id),
FOREIGN KEY (user_id) REFERENCES users(user_id));

create table order_items(item_id number(11) not null,item_name varchar(100),item_details varchar(2000), order_id number(11) not null,price float, PRIMARY KEY (item_id),
FOREIGN KEY (order_id) REFERENCES orders(order_id));

/**Create Autonumber using SEQUENCE & Triggers in the ID of the Primary Key **/
CREATE SEQUENCE USERS_UUID_SEQ START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER USERS_ID_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
IF :new.USER_ID IS NULL THEN
SELECT USERS_UUID_SEQ.nextval INTO :new.USER_ID FROM DUAL;
END IF;
END;

CREATE SEQUENCE ORDERS_UUID_SEQ START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER ORDER_ID_TRIGGER
BEFORE INSERT ON ORDERS
FOR EACH ROW
BEGIN
IF :new.ORDER_ID IS NULL THEN
SELECT ORDERS_UUID_SEQ.nextval INTO :new.ORDER_ID FROM DUAL;
END IF;
END;

CREATE SEQUENCE O_ITEMS_UUID_SEQ START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER O_ITEMS_ID_TRIGGER
BEFORE INSERT ON ORDER_ITEMS
FOR EACH ROW
BEGIN
IF :new.ITEM_ID IS NULL THEN
SELECT O_ITEMS_UUID_SEQ.nextval INTO :new.ITEM_ID FROM DUAL;
END IF;
END;
/** end of sequence and trigger create**/

select * from orders;  -- read for orders
select * from order_items; -- read for order_items
select * from users; -- read for users

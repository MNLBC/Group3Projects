select * from users;
select * from orders;
select * from order_items;
--Insert create or add row values in a table
--No need to indicate the id because sequence has been created
insert into users(first_name,last_name,date_created) values ('Melvin','Yu',sysdate);--First Customer
insert into orders(user_id) values (1);--Melvin's first Order
insert into order_items(item_name,item_details,order_id,price) values ('Iphone 6s', 'Phone made by Apple',1,25000.00);-- Order Item in first order
insert into order_items(item_name,item_details,order_id,price) values ('Samsung Galaxy S7', 'Phone Made by Samsung',1,29000.00);--Order Item in first order
insert into order_items(item_name,item_details,order_id,price) values ('Razer Blade', 'Laptop made by Razer',1,80000.00);--Order Item in first order
insert into orders(user_id) values (1);--Melvin Created another Order. with different order_items
insert into order_items(item_name,item_details,order_id,price) values ('Nissan Cup Noodles', 'Flavorful Spicy Noodles',2,100.00); --Order Item in 2nd order
insert into order_items(item_name,item_details,order_id,price) values ('Snickers', 'Delicious Chocolate Bar',2,150.00);--Order Item in 2nd order
insert into order_items(item_name,item_details,order_id,price) values ('Pocky', 'Chocolate Sticks',2,30.00);--Order Item in 2nd order

insert into users(first_name,last_name,date_created) values ('Katrina','De Leon',sysdate);--another customer
insert into orders(user_id) values (2);--Katrina's first order
insert into order_items(item_name,item_details,order_id,price) values ('H and M Bag', 'Fashionable Bag',3,5000.00);--katrina's first order item
insert into order_items(item_name,item_details,order_id,price) values ('Iphone 6s Plus', 'Phone made by Apple better than iphone 6s',3,32000.00);--katrina's first order item
insert into order_items(item_name,item_details,order_id,price) values ('Amazing Dress', 'Beautiful and Amazing Dress by Anonymous',3,8000.00);--katrina's first order item

--Delete it removes row values in a table
-- you can't delete from order and users unless there is no foreign key that is being use in another table
-- if there is no where it will delete all the data in the table
delete from order_items where item_name='Pocky';

--Update it change or modify a row value in the table
-- if there is no where it will update all the values in the set.
update order_items set price=30000.00
where item_name='Samsung Galaxy S7';

--commit it will persist or save the changes in the database. all the changes made by	DML -- data manipulation language (insert, update & delete)
commit;
-- rollback it will reset all the changes made by	DML -- data manipulation language (insert, update & delete) it can't roll back DDL -- Data Definition Language(Create, Drop & Alter)
rollback;

--SELECT it will display all the data that is called in the expression from table it can have where clause so you can filter the data you want to display in the table
--Select the number of orders per user
select u.first_name, count(o.order_id) as number_of_orders from users u, orders o
where u.user_id=o.user_id
group by u.FIRST_NAME;
--Select the number of items per user
select u.first_name, count(i.item_id) as number_of_items from users u, orders o, order_items i
where u.user_id=o.user_id
and i.order_id=o.order_id
group by u.FIRST_NAME;
--Total price of user of all the items he ordered
select u.first_name, SUM(i.price) as TOTAL_PRICE from users u, orders o, order_items i
where u.user_id=o.user_id
and i.order_id=o.order_id
group by u.FIRST_NAME;

--CREATE this defines the user, tables, sequences, triggers and Etc in the database.
--Create User
CREATE USER homework IDENTIFIED BY homework;
Create table cart(cart_id number(11) not null, product_name varchar(50));

--Alter this modifies a table it can change its definition. you can change column name, add new column update primary key, change data type, drop a column and etc.
ALTER TABLE cart
ADD CONSTRAINT cart_id PRIMARY KEY (cart_id);

select * from cart;
--Drop this removes the table and all of its data from the database
Drop table Cart;

--Grant this gives privledges to a user or table so it can be access by it.
GRANT CONNECT, RESOURCE TO homework;


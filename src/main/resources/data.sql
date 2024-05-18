insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(1, 'Василий', 'Петров', 23,'+79193572583');

update twoTables.CUSTOMERS SET name = 'Alexey' where name = 'Василий';

insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(2, 'Анатолий', 'Путин',49,'+79196872583');

insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(3, 'Генадий', 'Колобков', 32,'+79193825853');

insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(4, 'Олег', 'Тузиков', 22,'+79193281453');

insert into  twoTables.ORDERS(date, customer_id, product_name,amount)
values ('23.03.24', 2, 'TV', 1);

insert into  twoTables.ORDERS(date, customer_id, product_name,amount)
values ('19.04.24', 1, 'Smartphone', 2);

insert into  twoTables.ORDERS(date, customer_id, product_name,amount)
values ('01.05.24', 4, 'lamp', 3);

--changelog Shvyrev:1
create table twoTables.CUSTOMERS(
    id bigserial primary key not null ,
    name text not null ,
    surname text not null ,
    age int not null ,
    phone_number text
);
--rollback drop table twoTables.CUSTOMERS

--changelog Shvyrev:2
insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(1, 'Василий', 'Петров', 23,'+79193572583');

update twoTables.CUSTOMERS SET name = 'Alexey' where name = 'Василий';

insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(2, 'Анатолий', 'Путин',49,'+79196872583');

insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(3, 'Генадий', 'Колобков', 32,'+79193825853');

insert into twoTables.CUSTOMERS(id, name, surname, age, phone_number)
values(4, 'Олег', 'Тузиков', 22,'+79193281453');


--changelog Shvyrev:3
create table twoTables.ORDERS(
    id bigserial primary key not null,
    date text not null,
    customer_id bigint not null,
    product_name text not null,
    amount decimal not null,

    foreign key (customer_id) references twoTables.CUSTOMERS (id)
);
--rollback drop table twoTables.CUSTOMERS

--changelog Shvyrev:3
create table twoTables.ORDERS(
                                 id bigserial primary key not null,
                                 date text not null,
                                 customer_id bigint not null,
                                 product_name text not null,
                                 amount decimal not null,

                                 foreign key (customer_id) references twoTables.CUSTOMERS (id)
);
--rollback drop table twoTables.ORDERS

--changelog Shvyrev:4
insert into  twoTables.ORDERS(date, customer_id, product_name,amount)
values ('23.03.24', 2, 'TV', 1);

insert into  twoTables.ORDERS(date, customer_id, product_name,amount)
values ('19.04.24', 1, 'Smartphone', 2);

insert into  twoTables.ORDERS(date, customer_id, product_name,amount)
values ('01.05.24', 4, 'lamp', 3);






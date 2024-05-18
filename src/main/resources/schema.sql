create table twoTables.CUSTOMERS(
        id bigserial primary key not null ,
        name text not null ,
        surname text not null ,
        age int not null ,
        phone_number text
);

create table twoTables.ORDERS(
    id bigserial primary key not null,
    date text not null,
    customer_id bigint not null,
    product_name text not null,
    amount decimal not null,

    foreign key (customer_id) references twoTables.CUSTOMERS (id)
);
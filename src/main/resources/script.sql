SELECT name, surname, product_name FROM twoTables.ORDERS
JOIN twoTables.CUSTOMERS ON twoTables.CUSTOMERS.id = twoTables.ORDERS.customer_id
where name = :firstName;
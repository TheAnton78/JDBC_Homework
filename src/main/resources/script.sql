SELECT product_name FROM public.ORDERS
JOIN public.CUSTOMER ON public.CUSTOMER.id = public.ORDERS.customer_id
where name = ?1;
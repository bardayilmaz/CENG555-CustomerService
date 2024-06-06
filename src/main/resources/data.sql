-- CUSTOMER
INSERT INTO customer (id, created_date, modified_date, name, surname, email, is_premium)
VALUES (1, now(), now(), 'Bülent Arda', 'Yılmaz', 'bardayilmaz35@gmail.com', true);

INSERT INTO customer (id, created_date, modified_date, name, surname, email, is_premium)
VALUES (2, now(), now(), 'Mehmet Sarper', 'Kahvecioğlu', 'bardayilmaz35@gmail.com', false);

SELECT setval('customer_id_seq', (select max(id) + 1 from customer), false);

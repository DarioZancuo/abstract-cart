INSERT INTO t_categories (c_id, c_name, c_description) VALUES (1, 'Moda', 'Categoria della moda');
INSERT INTO t_categories (c_id, c_name, c_description) VALUES (2, 'Tech', 'Categoria tech');
INSERT INTO t_categories (c_id, c_name, c_description) VALUES (3, 'Viaggi', 'Categoria dei viaggi');
INSERT INTO t_categories (c_id, c_name, c_description) VALUES (4, 'Sport', 'Categoria dello sport');


INSERT INTO t_products (category_id, c_name, c_price) VALUES (1, 'MacBook Pro M4', 2499.00);
INSERT INTO t_products (category_id, c_name, c_price) VALUES (3, 'iPhone 17 Pro', 1199.00);
INSERT INTO t_products (category_id, c_name, c_price) VALUES (2, 'Dell UltraSharp 32', 850.50);
INSERT INTO t_products (category_id, c_name, c_price) VALUES (2,'Logitech MX Master 3S', 99.90);



-- Utente: admin | Password: admin
--INSERT INTO t_users (u_name, u_password) VALUES ('admin', '$2a$12$8.V9yX69Iat.u.5N4u86ru1N.P9j/RjM/F99u5pG4X6s5G1zX6pG');

-- Hash verificato (60 caratteri): admin
INSERT INTO t_users (u_name, u_password) VALUES ('admin', '$2a$12$8.V9yX69Iat.u.5N4u86ru1N.P9j/RjM/F99u5pG4X6s5G1zX6pGo');

-- password errata $2a$12$8.V9yX69Iat.u.5N4u86ru1N.P9j/RjM/F99u5pG4X6s5G1zX6pGo
-- password giusta $2a$10$o3fOAEjOZWGFQnyKiYl0LODTQd9jB5/LFTZ6l8OtWdbd3E2PDqwou
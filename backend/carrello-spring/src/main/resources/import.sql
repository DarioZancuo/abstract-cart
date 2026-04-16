INSERT INTO t_categories (c_name, c_description) VALUES ('Moda', 'Categoria della moda');
INSERT INTO t_categories (c_name, c_description) VALUES ('Tech', 'Categoria tech');
INSERT INTO t_categories (c_name, c_description) VALUES ('Viaggi', 'Categoria dei viaggi');
INSERT INTO t_categories (c_name, c_description) VALUES ('Sport', 'Categoria dello sport');


INSERT INTO t_products (category_id, c_name, c_description, c_price, c_img) VALUES (1, 'MacBook Pro M4', 'Laptop Apple con chip M4 di ultima generazione', 2499.00, 'https://www.notebookcheck.it/fileadmin/_processed_/3/f/csm_IMG_7593_a97c65292f.jpg');
INSERT INTO t_products (category_id, c_name, c_description, c_price, c_img) VALUES (3, 'iPhone 17 Pro', 'Smartphone Apple top di gamma con fotocamera avanzata', 1199.00, 'https://cdn.movertix.com/media/catalog/product/cache/image/i/p/iphone-17-pro-deep-blue-256gb_2_1.jpg');
INSERT INTO t_products (category_id, c_name, c_description, c_price, c_img) VALUES (2, 'Dell UltraSharp 32', 'Monitor professionale 32 pollici 4K', 850.50, 'https://i.pcmag.com/imagery/reviews/04tAxtxl7qY6W6z1nTGoaQX-3..v1569469975.jpg');
INSERT INTO t_products (category_id, c_name, c_description, c_price, c_img) VALUES (2, 'Logitech MX Master 3S', 'Mouse wireless ergonomico ad alte prestazioni', 99.90, 'https://m.media-amazon.com/images/I/613a-3jtieL.jpg');
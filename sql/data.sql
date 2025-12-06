insert into product (id, product_name, price,creation_datetime) values 
(1, 'Laptop Dell XPS', 4500.00, '2024-01-15 09:30:00'),
(2, 'iphone 13', 5200.00, '2024-02-01 14:10:00'), 
(3, 'Casque Sony WH1000', 890.50, '2024-02-10 16:45:00'),
(4, 'Clavier Logitech', 180.00, '2024-03-05 11:20:00'),
(5,'Ecran Samsung 27', 1200.00, '2024-03-18 08:00:00');

insert into product_category (id, product_category_name, product_id) values 
(1, 'informatique', 1),
(2, 'telephonique', 2), 
(3, 'audio', 3), 
(4, 'accessoires', 4),
(5, 'informatique', 5), 
(6, 'bureau', 5), 
(7, 'mobile', 2);
CREATE TABLE courierInfo
(courier_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(35) NOT NULL,
phone_number VARCHAR(20) NOT NULL,
delivery_type VARCHAR(5) NOT NULL);

INSERT INTO courierInfo(first_name, last_name, phone_number, delivery_type) VALUES
('John', 'Rython', '+ 38 050 655 0954', 'foot'),
('Kate', 'Looran', '+ 38 050 743 0146', 'car'),
('Bob', 'Kolaris', '+ 38 050 107 7798', 'car'),
('Michael', 'Frontal', '+ 38 050 566 5516', 'car');

CREATE TABLE customers
(customer_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(35) NOT NULL,
phone_number VARCHAR(20) NOT NULL,
district VARCHAR(15) NOT NULL,
street VARCHAR(25) NOT NULL,
house INT NOT NULL,
apartment INT NOT NULL);


INSERT INTO customers(first_name, last_name, phone_number, district, street, house, apartment) VALUES
('Penny', 'Smith', '+ 38 050 572 3771', 'South', 'First Avenue', 1, 10),
('Randy', 'Brown', '+ 38 050 568 8452', 'West', 'Spring St', 2, 35),
('Oliver', 'Thompson', '+ 38 050 782 5648', 'East', 'Five Avenue', 77, 14),
('James', 'Twist', '+ 38 050 752 1224', 'South', 'Corn St', 24, 89),
('Hellen', 'Bellora', '+ 38 050 555 4568', 'South', 'First Avenue', 11, 85),
('Kate', 'Evans', '+ 38 050 321 3211', 'West', 'Spring St', 123, 52),
('Jennifer', 'Radriges', '+ 38 050 321 1232', 'West', 'Roll St', 76, 44),
('Mario', 'Gordon', '+ 38 050 122 4554', 'East', 'Five Avenue', 21, 91),
('Bella', 'Lorenson', '+ 38 050 758 1667', 'North', 'Green Avenue', 23, 67),
('Erica', 'Visputchu', '+ 38 050 765 8582', 'South', 'First Avenue', 62, 44),
('Henry', 'Smith', '+ 38 050 657 5528', 'South', 'Brown St', 15, 56),
('Oscar', 'Rild', '+ 38 050 624 3643', 'South', 'First Avenue', 5, 13),
('William', 'Frankston', '+ 38 050 303 8181', 'North', 'Cascade Rd', 18, 88),
('Peter', 'Hall', '+ 38 050 466 7562', 'North', 'Cascade Rd', 17, 7),
('Ada', 'Watson', '+ 38 050 114 7812', 'South', 'Elma St', 18, 9);

CREATE TABLE deliveryList
(delivery_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
order_id INT UNIQUE NOT NULL,
courier_id INT NOT NULL,
date_arrived TIMESTAMP UNIQUE,  # the time when couriers bring ordes to clients
taken VARCHAR(3) NOT NULL,  # it means whether a client's taken its order or not
payment_method VARCHAR(4),
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (courier_id) REFERENCES courier_info(courier_id));


INSERT INTO deliveryList VALUES
(1, 1, 3, '2021-02-26 17:59:15', 'Yes', 'Cash'),
(2, 2, 4, '2021-02-26 18:01:05', 'Yes', 'Card'),
(3, 3, 1, '2021-02-26 18:04:36', 'Yes', 'Cash'),
(4, 4, 2, '2021-02-26 18:03:11', 'Yes', 'Cash'),
(5, 5, 1, '2021-02-26 18:19:56', 'Yes', 'Cash'),
(6, 6, 3, '2021-02-26 18:18:44', 'Yes', 'Card'),
(7, 7, 2, '2021-02-26 18:50:11', 'No', 'NULL'),  # the order's arrived too late
(8, 8, 4, '2021-02-26 18:35:07', 'Yes', 'Card'),
(9, 9, 4, '2021-02-26 18:58:28', 'NO', 'NULL'),   # the order's arrived too late
(10, 10, 3, '2021-02-26 18:36:51', 'Yes', 'Card'),
(11, 11, 2, '2021-02-26 19:10:34', 'Yes', 'Cash'),
(12, 12, 1, NULL, 'NO', 'NULL'),  # the products are out of stock
(13, 13, 2, '2021-02-26 19:17:04', 'Yes', 'Cash'),
(14, 14, 3, '2021-02-26 18:56:17', 'Yes', 'Card'),
(15, 15, 4, '2021-02-26 19:05:29', 'Yes', 'Card');

CREATE TABLE orders
(order_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
customer_id INT NOT NULL,
date_get TIMESTAMP NOT NULL,  # the time when orders are gotten from customers
FOREIGN KEY (customer_id) REFERENCES customers (customer_id));

INSERT INTO orders(customer_id, date_get) VALUES
(1, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(2, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(3, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(4, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(5, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(6, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(7, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(8, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(9, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(10, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(11, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(12, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(13, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(14, NOW());
INSERT INTO orders(customer_id, date_get) VALUES
(15, NOW());

CREATE TABLE ordersProducts
(order_id INT NOT NULL,
product_id INT NOT NULL,
quantity INT NOT NULL,
PRIMARY KEY (order_id, product_id),
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (product_id) REFERENCES products(product_id));

INSERT INTO ordersProducts VALUES
(1, 1, 2), (1, 4, 1), (1, 10, 1),
(2, 4, 1), (2, 5, 1),
(3, 3, 1),
(4, 7, 2), 
(5, 2, 1), (5, 3, 1),
(6, 8, 3),
(7, 1, 1), (7, 6, 4),
(8, 1, 2),
(9, 2, 1), (9, 3, 1),
(10, 1, 2), (10, 2, 1),
(12, 5, 2), (12, 10, 1),
(13, 4, 2),
(14, 5, 1),
(15, 8, 1), (15, 7, 2);

CREATE TABLE products
(product_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
menu_name VARCHAR(80) NOT NULL,
price FLOAT NOT NULL);

INSERT INTO products(menu_name, price) VALUES
('GOJIRA ROLL', 12.6),
('VIVA LAS VEGAS ROLL', 15.7),
('FUTOMAKI', 14.4),
('TOOTSY MAKI', 14.1),
('ZONIE ROLL', 15.5),
('NUTTY GRILLED SALAD', 10.5),
('SASHIMI SALAD', 12.0),
('SUNNY TEA', 3.75),
('COFFEE', 4.1),
('MINERAL WATER', 2.0);

# Descending sort by the amount of orders per month
SELECT month_name, amount_of_orders
FROM year_statistics
ORDER BY amount_of_orders DESC;

# The sum of the amount of orders for one year
SELECT SUM(amount_of_orders) AS orders_per_year FROM year_statistics;

# The maximum amount of orders for one month
SELECT month_name, amount_of_orders FROM year_statistics
WHERE amount_of_orders = (SELECT MAX(amount_of_orders)
FROM year_statistics);

# How many orders each courier has delivered to a client
SELECT courier_id, COUNT(order_id)
From delivery_list
WHERE date_arrived IS NOT NULL
GROUP BY courier_id;

# Information about the customers who live in South district
SELECT * FROM Customers
WHERE district IN ('South');

# Information about the orders that have not been taken
SELECT * FROM delivery_list
WHERE taken NOT IN ('Yes');

# Find out products from the menu that have been ordered
SELECT menu_name FROM products
WHERE EXISTS
(SELECT * FROM orders_products WHERE orders_products.product_id = products.product_id);

# Find out products from the menu that have not been ordered
SELECT menu_name FROM products
WHERE NOT EXISTS
(SELECT * FROM orders_products WHERE orders_products.product_id = products.product_id);

# Find the frequency of districts among the clients 
SELECT district 
FROM customers
GROUP BY district
ORDER BY COUNT(district) DESC;

# Get a list of customers and couriers information
SELECT 'Customer' AS category, first_name, last_name, phone_number
FROM customers
UNION
SELECT 'Employee' AS category, first_name, last_name, phone_number
FROM courier_info;

# Check the details for each order
SELECT orders_products.order_id, products.menu_name, quantity, ROUND(price*quantity, 2) AS total_price
FROM orders_products
INNER JOIN products ON orders_products.product_id = products.product_id
ORDER BY order_id, quantity;

# The information about orders and delivery details
SELECT *, SEC_TO_TIME(TIMESTAMPDIFF(second, date_get, date_arrived))  AS time_of_delivery
FROM orders
NATURAL JOIN delivery_list;

# The table show us all the available districts for every courier on car 
SELECT DISTINCT courier_info.courier_id, customers.district
FROM courier_info
CROSS JOIN customers WHERE courier_info.delivery_type = 'car'
ORDER BY courier_id;

# The information about a customer's name and their number of the order
SELECT customers.first_name, customers.last_name,  customers.phone_number, orders.order_id
FROM customers
LEFT JOIN orders ON customers.customer_id = orders.customer_id;
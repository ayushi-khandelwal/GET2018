DROP DATABASE StoreFront;

CREATE DATABASE StoreFront;
USE StoreFront;
  
CREATE TABLE user(
    user_id INT NOT NULL,
    name VARCHAR(30),
    phone INT,
    dob DATE,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(20),
    user_type VARCHAR(20),
    PRIMARY KEY(user_id));

CREATE TABLE address(
   address_id INT NOT NULL,
   user_id INT,
   area VARCHAR(50),
   city VARCHAR(30),
   state VARCHAR(30),
   country VARCHAR(30),
   FOREIGN KEY(user_id) REFERENCES user(user_id),
   PRIMARY KEY(address_id));
  
CREATE TABLE category(
    category_id INT AUTO_INCREMENT, 
    category_name VARCHAR(255) NOT NULL,
    parent_category VARCHAR(255) NOT NULL, 
    PRIMARY KEY (category_id));
  
CREATE TABLE product(
    product_id INT AUTO_INCREMENT, 
    product_title VARCHAR(255) NOT NULL, 
    product_description VARCHAR(255), 
    quantity VARCHAR(255) NOT NULL, 
    category_id INT, 
    unit_price INT NOT NULL, 
    FOREIGN KEY(category_id) REFERENCES category(category_id), 
    PRIMARY KEY (product_id));

CREATE TABLE image(
   image_id INT NOT NULL,
   image_name VARCHAR(30),
   product_id INT,
   image_URL VARCHAR(30),
   PRIMARY KEY(image_id),
   FOREIGN KEY(product_id) REFERENCES product(product_id));

CREATE TABLE orders(
   order_id INT NOT NULL,
   user_id int,
   order_date DATE,
   order_amount INT,
   shipping_address VARCHAR(300),
   order_status varchar(12),
   PRIMARY KEY(order_id),
   FOREIGN KEY(user_id) REFERENCES user(user_id));

CREATE TABLE products_in_order (
   order_id INT,
   product_id INT,
   status VARCHAR(20));
   
SHOW TABLES;

DROP TABLE image;
DROP TABLE product;

CREATE TABLE product(
    product_id INT AUTO_INCREMENT, 
    product_title VARCHAR(255) NOT NULL, 
    product_description VARCHAR(255), 
    quantity VARCHAR(255) NOT NULL, 
    category_id INT, 
    unit_price INT NOT NULL, 
    FOREIGN KEY(category_id) REFERENCES category(category_id), 
    PRIMARY KEY (product_id));

CREATE TABLE image(
   image_id INT NOT NULL,
   image_name VARCHAR(30),
   product_id INT,
   image_URL VARCHAR(30),
   PRIMARY KEY(image_id),
   FOREIGN KEY(product_id) REFERENCES product(product_id));


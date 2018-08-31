CREATE DATABASE employee;
USE employee;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    date_of_birth
    DATE NOT NULL,
    contact_no INT NOT NULL,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(50) NOT NULL,
    organization VARCHAR(20) NOT NULL
   );

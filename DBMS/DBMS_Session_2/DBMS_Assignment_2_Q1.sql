# DBMS SESSION 2

# DBMS SESSION_2 Question_1

/*
*  SQL file containing script for creating database and tables
*/
DROP DATABASE if exists StoreFront;
CREATE DATABASE if not exists StoreFront;
USE StoreFront;

CREATE TABLE if not exists Category(
    Category_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Category_Name VARCHAR(20),
    Parent_Category INT
);

CREATE TABLE if not exists Product(
    Product_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Title VARCHAR(30),
    Product_Description VARCHAR(200),
    Unit_Price INT,
    Stock_Quantity INT,
    Issue_Date DATE
);

CREATE TABLE if not exists Product_Category (
    Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Id INT NOT NULL,
    Category_Id INT NOT NULL,
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
    FOREIGN KEY(Category_Id) REFERENCES Category(Category_Id)
);

CREATE TABLE if not exists Image(
    Image_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Id INT,
    Image_URL VARCHAR(30),
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id)
); 

CREATE TABLE if not exists User(
    User_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    User_Name VARCHAR(30),
    User_Mail VARCHAR(50) NOT NULL,
    Birth_Date DATE,
    Contact_No INT
);

CREATE TABLE if not exists Address(
    Address_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    User_Id INT,
    Area VARCHAR(200),
    City VARCHAR(30),
    Zipcode INT,
    State VARCHAR(30),
    Country VARCHAR(30),
    FOREIGN KEY(User_Id) REFERENCES User(User_Id)
);

CREATE TABLE if not exists Login(
    User_Id int,
    Password VARCHAR(10),
    User_Role VARCHAR(30),
    Last_Login DATE,
    FOREIGN KEY(User_Id) REFERENCES User(User_Id)
);

CREATE TABLE if not exists Orders(
    Order_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    User_Id int,
    Order_Date DATE,
    Order_Amount INT,
    Shipping_Address VARCHAR(300),
    FOREIGN KEY(User_Id) REFERENCES User(User_Id)
);

CREATE TABLE if not exists Order_Status (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Order_Id INT,
    Product_Id INT,
    Quantity INT,
    OrderStatus VARCHAR(20),
    FOREIGN KEY(Order_Id) REFERENCES Orders(Order_Id),
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id)
);

DROP TABLE Image;
DROP TABLE Product_Category;
DROP TABLE Order_Status;
DROP TABLE Product;

CREATE TABLE if not exists Product(
    Product_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Title VARCHAR(30),
    Product_Description VARCHAR(200),
    Unit_Price INT,
    Stock_Quantity INT,
    Issue_Date DATE
);

CREATE TABLE if not exists Product_Category (
    Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Id INT NOT NULL,
    Category_Id INT NOT NULL,
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
    FOREIGN KEY(Category_Id) REFERENCES Category(Category_Id)
);

CREATE TABLE if not exists Image(
    Image_Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Id INT,
    Image_URL VARCHAR(30),
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id)
); 

CREATE TABLE if not exists Order_Status (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Order_Id INT,
    Product_Id INT,
    Quantity INT,
    OrderStatus VARCHAR(20),
    FOREIGN KEY(Order_Id) REFERENCES Orders(Order_Id),
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id)
);
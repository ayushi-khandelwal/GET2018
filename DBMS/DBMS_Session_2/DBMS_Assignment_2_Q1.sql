
/*
*  SQL file containing script for creating database and tables
*/
DROP DATABASE StoreFront;
CREATE DATABASE StoreFront;
USE StoreFront;

CREATE TABLE Category(
    Category_Id INT NOT NULL AUTO_INCREMENT,
    Category_Name VARCHAR(20),
    Parent_Category INT,
    PRIMARY KEY(Category_Id)
);

CREATE TABLE Product(
    Product_Id INT NOT NULL AUTO_INCREMENT,
    Product_Title VARCHAR(30),
    Product_Description VARCHAR(200),
    Unit_Price INT,
    Stock_Quantity INT,
    Issue_Date DATE,
    PRIMARY KEY(Product_Id)
);

CREATE TABLE Product_Category (
    Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Id INT NOT NULL,
    Category_Id INT NOT NULL,
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
    FOREIGN KEY(Category_Id) REFERENCES Category(Category_Id)
);

CREATE TABLE Image(
    Image_Id INT NOT NULL AUTO_INCREMENT,
    Product_Id INT,
    Image_URL VARCHAR(30),
    PRIMARY KEY(Image_Id),
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id)
); 

CREATE TABLE User(
    User_Id INT NOT NULL AUTO_INCREMENT,
    User_Name VARCHAR(30),
    User_Mail VARCHAR(50) NOT NULL,
    Birth_Date DATE,
    Contact_No INT,
    PRIMARY KEY(User_Id)
);

CREATE TABLE Address(
    Address_Id INT NOT NULL AUTO_INCREMENT,
    User_Id INT,
    Area VARCHAR(200),
    City VARCHAR(30),
    Zipcode INT,
    State VARCHAR(30),
    Country VARCHAR(30),
    FOREIGN KEY(User_Id) REFERENCES User(User_Id),
    PRIMARY KEY(Address_Id)
);

CREATE TABLE Login(
    User_Id int,
    Password VARCHAR(10),
    User_Role VARCHAR(30),
    Last_Login DATE,
    FOREIGN KEY(User_Id) REFERENCES User(User_Id)
);

CREATE TABLE Orders(
    Order_Id INT NOT NULL AUTO_INCREMENT,
    User_Id int,
    Order_Date DATE,
    Order_Amount INT,
    Shipping_Address VARCHAR(300),
    Order_Status varchar(12),
    PRIMARY KEY(Order_Id),
    FOREIGN KEY(User_Id) REFERENCES User(User_Id)
);

CREATE TABLE Products_In_Order (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Order_Id INT,
    Product_Id INT,
    Quantity INT,
    status VARCHAR(12)
);

DROP TABLE Image;
DROP TABLE Product_Category;
DROP TABLE Product;

CREATE TABLE Product(
    Product_Id INT NOT NULL AUTO_INCREMENT,
    Product_Title VARCHAR(30),
    Product_Description VARCHAR(200),
    Unit_Price INT,
    Stock_Quantity INT,
    Issue_Date DATE,
    PRIMARY KEY(Product_Id)
);

CREATE TABLE Product_Category (
    Id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Product_Id INT NOT NULL,
    Category_Id INT NOT NULL,
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id),
    FOREIGN KEY(Category_Id) REFERENCES Category(Category_Id)
);

CREATE TABLE Image(
    Image_Id INT NOT NULL AUTO_INCREMENT,
    Product_Id INT,
    Image_URL VARCHAR(30),
    PRIMARY KEY(Image_Id),
    FOREIGN KEY(Product_Id) REFERENCES Product(Product_Id)
); 

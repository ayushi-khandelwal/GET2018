
-- ------------------------------------ DBMS SESSION_3 -------------------------------

-- ---------------- DBMS SESSION_3 - Assignment_2 ------------------------

#1. Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT		Product.Product_Id,
			Product.Product_Title,
			count(Product_Category.Product_Id) AS CountOfCategories
        
FROM		Product INNER JOIN Product_Category ON
				Product.Product_Id = Product_Category.Product_Id 
            
GROUP BY	Product_Category.Product_Id
HAVING		count(Product_Category.Product_Id) > 1;

#2. Display Count of products as per below price range: Range in Rs. 0 - 100, 101 - 500, Above 500
SELECT		product.RangeInRs, count(*) AS ProductCount
FROM		(SELECT	CASE
                    WHEN Unit_Price BETWEEN 0 AND 100 THEN "0 - 100"
                    WHEN Unit_Price BETWEEN 101 AND 500 THEN "101 - 500"
                    WHEN Unit_Price > 501 THEN "Above 501"
                END AS RangeInRs
        FROM	Product) product
GROUP BY	product.RangeInRs;

#3. Display the Categories along with number of products under each category.
SELECT		Category_Name, count(Product_Category.category_Id) AS NumberOfProducts
FROM		Product_Category LEFT JOIN Category ON
				Product_Category.Category_Id = Category.Category_Id
GROUP BY	Product_Category.category_Id;

-- -------------------- DBMS SESSION_3 - Assignment_3 -----------------------

#1. Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT		User.*, count(*) AS OrderCount
        
FROM		User INNER JOIN Orders ON User.User_Id = Orders.User_Id
				INNER JOIN Order_Status ON Order_Status.Order_Id = Orders.Order_Id

WHERE		Orders.Order_Date >= (CURRENT_DATE() - 30) AND
			Order_Status.OrderStatus LIKE "%placed%"
            
GROUP BY	Orders.User_Id;

#2. Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT		User.User_Name, SUM(Product.Unit_Price * Product.Stock_Quantity) AS TotalAmount

FROM		User 
			INNER JOIN Orders ON User.User_Id = Orders.User_Id
			INNER JOIN Order_Status ON Orders.Order_Id = Order_Status.Order_Id
            INNER JOIN Product ON Product.Product_Id = Order_Status.Product_Id
            
WHERE		Orders.Order_Date > (CURRENT_DATE() - 30)
GROUP BY	User.User_Name
ORDER BY	TotalAmount DESC
LIMIT 		10;

#3. Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT		Product.Product_Title, SUM(Order_Status.Quantity) AS ProductCount

FROM		Product 
			INNER JOIN Order_Status ON Product.Product_Id = Order_Status.Product_Id
			INNER JOIN Orders on Orders.Order_Id = Order_Status.Order_Id
            
WHERE		Orders.Order_Date > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
GROUP BY	Product.Product_Id
ORDER BY	ProductCount DESC
LIMIT		20;

#4. Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT 		MONTHNAME(Orders.Order_Date) AS MonthName, SUM(Product.Unit_Price * Order_Status.Quantity) AS OrderTotal

FROM 		Orders
LEFT JOIN 	Order_Status ON Orders.Order_Id = Order_Status.Order_Id
LEFT JOIN 	Product ON Product.Product_Id = Order_Status.Product_Id

WHERE 		Orders.Order_Date > DATE_SUB(CURDATE(), INTERVAL 6 MONTH) 
GROUP BY 	MONTH(Orders.Order_Date);

#5 Mark the products as Inactive which are not ordered in last 90 days.
UPDATE		Product
INNER JOIN 	Order_Status ON  Product.Product_Id = Order_Status.Product_Id
INNER JOIN 	Orders ON Orders.Order_Id = Order_Status.Order_Id 

SET 		Product.Stock_Quantity = 0	

WHERE		Orders.Order_Date > DATE_SUB(CURDATE(), INTERVAL 90 DAY) AND NOT
			Order_Status.OrderStatus LIKE "%placed%";

/* To check previous query */
SELECT * FROM Product;
                    
#6 Given a category search keyword, display all the Products present in this category/categories. 
SELECT		Product.Product_Title

FROM		Product
INNER JOIN	Product_Category ON Product.Product_Id = Product_Category.Product_Id
INNER JOIN	Category ON Product_Category.Category_Id = Category.Category_Id

WHERE		Category.Category_Name = "Jeans";

#7 Display top 10 Items which were cancelled most.
SELECT		Product.Product_Title AS Item, count(*) AS CancelledCount
FROM		Product
INNER JOIN	Order_Status ON Product.Product_Id = Order_Status.Product_Id
WHERE		Order_Status.OrderStatus LIKE "%cancelled%"
GROUP BY	Product.Product_Title
ORDER BY	CancelledCount DESC
LIMIT		10;

-- ---------------- DBMS SESSION_3 - Assignment_4 ------------------------

/* Consider a form where providing a Zip Code populates associated City and State. 
Create appropriate tables and relationships for the same and write a SQL query for
that returns a Resultset containing Zip Code, City Names and 
States ordered by State Name and City Name. */
CREATE TABLE ZipcodeTable (
Zipcode INT NOT NULL PRIMARY KEY,
City VARCHAR(15),
State VARCHAR(15) );

INSERT INTO ZipcodeTable VALUES
(302017, 'Jaipur', 'Rajasthan'),
(313001, 'Udaipur', 'Rajasthan'),
(305025, 'Ajmer', 'Rajasthan'),
(302025, 'Jaipur', 'Rajasthan');

SELECT      Zipcode, City, State
FROM        ZipcodeTable
ORDER BY    State, City;

-- ---------------- DBMS SESSION_3 - Assignment_4 ------------------------

/* Create a view displaying the order information 
(Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered
items should be displayed first for last 60 days.. */
CREATE      VIEW OrderInformation
AS
SELECT      Orders.Order_Id, 
            Product.Product_Id, 
            Product.Product_Title,  
            Product.Unit_Price, 
            User.User_Name,
            User.User_Mail,
            Orders.Order_Date, 
            Order_Status.OrderStatus
        
FROM        Orders
LEFT JOIN   Order_Status ON Orders.Order_Id = Order_Status.order_Id
LEFT JOIN   Product ON Order_Status.Product_Id = Product.Product_Id
LEFT JOIN   User ON Orders.User_Id = User.User_Id

WHERE       Orders.Order_Date > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY    Orders.Order_Date DESC;

DROP VIEW OrderInformation;

SELECT * FROM OrderInformation;

#2 Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT DISTINCT Product_Title
FROM OrderInformation
WHERE OrderStatus LIKE "%shipped%";

#3 Use the above view to display the top 5 most selling products
SELECT      Product.Product_Id,
            Product.Product_Title,
            SUM(Order_Status.Quantity) AS ProductCount

FROM        Product
INNER JOIN  Order_Status ON Product.Product_ID= Order_Status.Product_Id
INNER JOIN  Orders ON Orders.Order_Id = Order_Status.Order_Id

GROUP BY    Product_ID
ORDER BY    ProductCount DESC
LIMIT       5;
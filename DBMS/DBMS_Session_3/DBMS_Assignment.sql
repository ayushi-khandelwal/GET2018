#Question 2
#1
SELECT p.productID, p.productName, COUNT(cpr.productID) AS categoryCount
FROM product AS p
LEFT JOIN categoryProductRelationship AS cpr ON p.productID = cpr.productID 
GROUP BY cpr.productID
HAVING COUNT(cpr.productID) > 1;

#2
SELECT pr.priceRange,COUNT(*) AS ProductCount 
FROM(SELECT CASE
       WHEN price>0 AND price<100 THEN '0-100'
       WHEN price>100 AND price<500 THEN '100-500'
       ELSE 'Above 500' END AS priceRange
   FROM product) pr
GROUP BY pr.priceRange;

#3
SELECT c.categoryName, COUNT(*) AS productCount
FROM category AS c
LEFT JOIN categoryProductRelationship AS cpr ON c.categoryID = cpr.categoryID 
GROUP BY cpr.categoryID;

#Question 3
#1
SELECT u.userID, u.userName, u.emailID, u.dateOfBirth, COUNT(o.userID) AS orderCount
FROM user AS u
LEFT JOIN orders AS o ON u.userID = o.userID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
GROUP BY o.userID;

#2
SELECT u.userID, u.userName, u.emailID, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM user AS u
LEFT JOIN orders AS o ON u.userID = o.userID
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
GROUP BY u.userID
ORDER BY orderTotal DESC
LIMIT 10;

#3
SELECT p.productName, SUM(opr.numberOfProduct) AS productCount
FROM product as p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
LEFT JOIN orders AS o ON opr.orderID = o.orderID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 60 DAY) 
GROUP BY p.productID
ORDER BY productCount DESC
LIMIT 20;

#4
SELECT MONTHNAME(o.orderPlacingDate) AS monthName, SUM(p.price * opr.numberOfProduct) AS orderTotal
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 6 MONTH) 
GROUP BY MONTH(o.orderPlacingDate);

#5
ALTER TABLE product
ADD productState CHAR(10) DEFAULT 'Active'
AFTER details;

UPDATE product AS p
SET p.productState = "Active";

UPDATE product AS p
LEFT JOIN orderProductRelationship AS opr ON p.productID = opr.productID
LEFT JOIN orders AS o ON opr.orderID = o.orderID
SET p.productState = "Inactive"
WHERE o.orderPlacingDate < DATE_SUB(CURDATE(), INTERVAL 90 DAY)
AND p.productID Not IN(
                        SELECT productID
                        FROM orderProductRelationship AS opr
                        LEFT JOIN orders AS o ON opr.orderID = o.orderID
                        WHERE o.orderPlacingDate >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
                       );
                       
#6
SELECT p.productName
FROM product AS p
LEFT JOIN categoryProductRelationship AS cpr ON p.productID = cpr.productID
LEFT JOIN category AS c ON cpr.categoryID = c.categoryID
WHERE c.categoryName IN ('electronics');

#7
SELECT productID, COUNT(*) AS canceledCount
FROM orderProductRelationship
WHERE status = 'canceled'
GROUP BY productID
ORDER BY canceledCount DESC
LIMIT 10;

#Question 4
CREATE TABLE zipcode
(
    zipcode INT NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    PRIMARY KEY(zipcode)
);

INSERT INTO zipcode VALUES
(313001, 'Udaipur', 'Rajasthan'),
(302019, 'Jaipur', 'Rajasthan'),
(302020, 'Jaipur', 'Rajasthan'), 
(302021, 'Jaipur', 'Rajasthan');

SELECT zipcode, city, state
FROM zipcode
ORDER BY state, city;

#Question 5
#1
CREATE VIEW orderInformation
AS
SELECT o.orderID, p.productID, p.productName, opr.numberOfProduct, p.price, 
       u.userName, u.emailID, o.orderPlacingDate, opr.status
FROM orders AS o
LEFT JOIN orderProductRelationship AS opr ON o.orderID = opr.orderID
LEFT JOIN product AS p ON opr.productID = p.productID
LEFT JOIN user AS u ON o.userID = u.userID
WHERE o.orderPlacingDate > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY o.orderPlacingDate DESC;

drop view orderInformation;

SELECT * FROM orderInformation;

#2
SELECT DISTINCT productName
FROM orderInformation
WHERE status = 'shipped';

#3
Select productName, SUM(numberOfProduct) AS productSold
FROM orderInformation
GROUP BY productID
ORDER BY productSold DESC
LIMIT 5;
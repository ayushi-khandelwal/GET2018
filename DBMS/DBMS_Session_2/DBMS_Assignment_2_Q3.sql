USE StoreFront;

/* Display Recent 50 Orders placed (Id, Order Date, Order Total). */
SELECT		Order_Id AS Id,
			Order_Date AS Date,
			Order_Amount AS Total

FROM		Orders
ORDER BY	Order_Date DESC
LIMIT		50;

/* Display 10 most expensive Orders. */
SELECT		User_Id,
			Order_Id AS Id,
			Order_Date AS Date,
			Order_Amount AS Total
            
FROM		Orders
ORDER BY	Order_Amount DESC
LIMIT		10;

/* Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped. */
SELECT	Orders.Order_Id,
        Order_Status.Product_Id,
		Orders.Order_Date,
        Orders.Order_Amount,
        Order_Status.OrderStatus
        
FROM		Orders 
INNER JOIN 	Order_Status ON
				Orders.Order_Id = Order_Status.Order_Id
        
WHERE	Orders.Order_Date < (CURRENT_DATE() - 10) AND
		Order_Status.OrderStatus LIKE "%placed%";

/* Display list of shoppers which haven't ordered anything since last month. */
SELECT      User.User_Id,
            User.User_Name AS Shopper_Name,
            IFNULL(Orders.Order_Date, "NOT ORDERED YET") AS Last_Ordered

FROM        User
LEFT JOIN   Orders ON User.User_Id = Orders.User_Id
				
WHERE		    User.User_Id NOT IN (SELECT     User.User_Id
                                 FROM       User
                                 LEFT JOIN  Orders ON User.User_Id = Orders.User_Id
                                 WHERE      Orders.Order_Date BETWEEN (CURRENT_DATE() - 30) AND CURRENT_DATE());

/* Display list of shopper along with orders placed by them in last 15 days.  */
SELECT	    Orders.Order_Id AS Id,
            User.User_Name AS Shopper_Name,
            Orders.Order_Date AS Date
        
FROM        User 
INNER JOIN  Orders ON User.User_Id = Orders.User_Id
INNER JOIN  Order_Status ON Orders.Order_Id = Order_Status.Order_Id

WHERE       Orders.Order_Date > (CURRENT_DATE() - 15) AND
            Order_Status.OrderStatus LIKE "%placed%";

/* Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020)) */
SELECT	Product.Product_Title AS Items

FROM	Product INNER JOIN Order_Status ON
			Product.Product_Id = Order_Status.Product_Id
            
WHERE	Order_Status.Order_Id = '05' AND
		Order_Status.OrderStatus LIKE "%shipped%";
         
/* Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price. */
SELECT	Product.Product_Title AS Items,
		Orders.Order_Date

FROM	Product INNER JOIN Order_Status ON
			Product.Product_Id = Order_Status.Product_Id
		INNER JOIN	Orders ON
			Orders.Order_Id = Order_Status.Order_Id

WHERE	Product.Unit_Price BETWEEN '20' AND '50';				

/* Update first 20 Order items status to “Shipped” which are placed today. */
UPDATE	Order_Status INNER JOIN Orders ON 
			Order_Status.Order_ID=Orders.Order_ID
SET		Order_Status.OrderStatus = 'shipped'
WHERE	Orders.Order_Date LIKE current_date();


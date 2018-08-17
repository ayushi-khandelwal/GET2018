USE StoreFront;

#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT      Order_Id, Order_Date, Order_Amount
FROM        Orders
ORDER BY    order_date DESC
LIMIT       50;

#Display 10 most expensive Orders.
SELECT      Order_Id, user_id, Order_date, Order_Amount
FROM        Orders
ORDER BY    Order_Amount DESC
LIMIT       10;

/*Display all the Orders which are placed more than 10 days old and 
one or more items from those orders are still not shipped.*/
SELECT      Orders.Order_Id, 
            Orders.User_Id, 
            Order_Date, 
            Order_Amount,
            Order_Status 
            
FROM        Orders 

INNER JOIN  Order_Status ON 
            Orders.Order_Id = Order_Status.Order_Id
            
WHERE       Order_Date >= CURRENT_DATE - 10 AND NOT 
            Order_Status = 'shipped';


#Display list of shoppers which haven't ordered anything since last month.
SELECT      User.User_Id, User.User_Name as Shopper_name
FROM        User
WHERE       User.User_Id NOT IN (SELECT User.User_Id 
                                 FROM User 
                                 INNER JOIN Orders 
                                 ON User.User_Id = Orders.user_id 
                                 WHERE Orders.order_date >= CURRENT_DATE - 30);

         
 

#Display list of shopper along with orders placed by them in last 15 days. 
SELECT      User.User_Id, User.User_Name as Shopper_name, OrderS.Order_Id AS Order_ID, Orders.order_date AS Order_date
FROM        User 
INNER JOIN  Orders ON         
            User.User_Id = Orders.user_id

WHERE       Orders.order_date >= CURRENT_DATE - 15;

#Display list of order items which are in “shipped” state
SELECT  Order_Id, Product_Id, Status
FROM    Order_Status
WHERE   Status = 'shipped';

#Display list of order items along with order placed date which fall between Rs 20 to Rs 100 price.
SELECT  orderStatus.Order_Id,
        orders.user_Id,
        product.Product_Id,
        product.Product_Title,
        product.Unit_Price,
        status

FROM    Order_Status orderStatus, Product product, Orders orders
WHERE   orderStatus.Order_Id = orders.Order_Id AND
        orderStatus.Product_Id = product.Product_Id AND
        product.Unit_Price > 20 AND
        product.Unit_Price < 100;

#Update first 20 Order items status to “Shipped” which are placed today.
CREATE      VIEW shippedItems AS 
            SELECT product_ID 
            FROM Order_Status 
        
LEFT JOIN   Orders ON 
            Order_Status.product_ID = Orders.Order_Id 
            
WHERE       Order_Date = CURRENT_DATE 

ORDER BY    Order_Date;

UPDATE      Order_Status 
SET order_status = 'shipped' 

WHERE product_ID IN (SELECT product_ID 
                     FROM shippedItems);


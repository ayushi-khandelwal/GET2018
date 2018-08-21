USE StoreFront;

/* 1 Create a function to calculate number of orders in a month. 
Month and year will be input parameter to function. */
DROP FUNCTION IF EXISTS getNumberOfOrdersInMonth;

DELIMITER $$

CREATE FUNCTION getNumberOfOrdersInMonth (Order_Month INT, Order_Year INT)
    RETURNS INT DETERMINISTIC

    BEGIN
        DECLARE OrderCount INT;
        SET     OrderCount =   (SELECT	COUNT(*)
                                FROM 	    Orders
                                WHERE 	MONTH(Orders.Order_Date) = Order_Month AND
                                        YEAR(Orders.Order_Date) = Order_Year);
        RETURN (OrderCount);
    END $$
DELIMITER ;

SELECT getNumberOfOrdersInMonth(8, 2018) AS total_order;

/* 2 Create a function to return month in a year having maximum orders. 
Year will be input parameter. */
DROP FUNCTION IF EXISTS StoreFront.getMonthOfMaximumOrders;

DELIMITER $$

CREATE FUNCTION getMonthOfMaximumOrders (Order_Year INT)
    RETURNS INT DETERMINISTIC

    BEGIN
        DECLARE Max_Order_Month INT;
        SET 	Max_Order_Month = (SELECT   MONTH(Order_Date)
                                 FROM     Orders
                                 WHERE		YEAR(Orders.Order_Date) = Order_Year
                                 ORDER BY	getNumberOfOrdersInMonth(MONTH(Order_Date),YEAR(Orders.Order_Date)) DESC
                                 LIMIT		1);
                                     
        RETURN	(Max_Order_Month);
    END $$
DELIMITER ;

SELECT GETMONTHOFMAXIMUMORDERS(2018) AS maximum_Order_Month;

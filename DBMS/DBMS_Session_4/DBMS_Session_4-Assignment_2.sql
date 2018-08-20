/* 1. Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function. */
DROP PROCEDURE if exists GetAverageSale;
DELIMITER $$
CREATE PROCEDURE GetAverageSale (IN Order_Month INT, IN Order_Year INT)
BEGIN
	SELECT		Order_Status.Product_Id, 
				Product.Product_Title, 
                AVG(Product.Unit_Price * Order_Status.Quantity)/DAY(LAST_DAY(Orders.Order_Date)) AS Average_Sale
                
    FROM		Orders
		INNER JOIN Order_Status ON Orders.Order_Id = Order_Status.Order_Id 
        INNER JOIN Product ON Order_Status.Product_Id = Product.Product_Id
        
    WHERE		MONTH(Order_Date) = Order_Month AND
				YEAR(Order_Date) = Order_Year
                
	GROUP BY	Order_Status.Product_Id;
END $$
    
CALL GetAverageSale(8, 2018);

CALL GetAverageSale(7, 2018);

/* 2. Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date. */
DELIMITER $$ 
CREATE FUNCTION ValidateDate(StartDate Date, EndDate Date)
RETURNS DATE DETERMINISTIC

BEGIN
    DECLARE SetStartDate DATE;
  
    IF (StartDate < EndDate)
        THEN
        RETURN StartDate;
                
    ELSE
        SET SetStartDate = DATE_ADD(DATE_ADD(LAST_DAY(EndDate), INTERVAL 1 DAY), INTERVAL - 1 MONTH);
        RETURN SetStartDate;
    END IF;

END$$

DROP PROCEDURE if exists GetOrderDetails;
DELIMITER $$
CREATE PROCEDURE GetOrderDetails (IN StartDate Date, EndDate Date)
SET StartDate = ValidateDate(StartDate, EndDate);
BEGIN
	SELECT		Orders.*, Order_Status.OrderStatus
    FROM		Order_Status
		RIGHT JOIN Orders ON Orders.Order_Id = Order_Status.Order_Id
	
    WHERE		Orders.Order_Date BETWEEN StartDate AND EndDate;
END$$

CALL GetOrderDetails('2018-08-01', '2018-08-30');
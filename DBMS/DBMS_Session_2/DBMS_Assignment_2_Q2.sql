USE StoreFront;

LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Category_Data.txt' INTO TABLE Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Category_Name,Parent_Category);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Product_Data.txt' INTO TABLE Product FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Title,Product_Description,Unit_Price,Stock_Quantity, Issue_Date);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/User_Data.txt' INTO TABLE User FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Name,User_Mail,Birth_Date,Contact_no);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Address_Data.txt' INTO TABLE Address FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Area,City,Zipcode,State,Country);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Image_Data.txt' INTO TABLE Image FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Id,Image_URL);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Login_Data.txt' INTO TABLE Login FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Password,User_Role,Last_Login);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Product_Category_Data.txt' INTO TABLE Product_Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Id,Category_Id);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Order_Data.txt' INTO TABLE Orders FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Order_Date,Order_Amount,Shipping_Address);
LOAD DATA INFILE 'G:/GET2018/DBMS/Data_Text_Files/Order_Status_Data.txt' INTO TABLE Order_Status FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Order_Id,Product_Id,Quantity,OrderStatus);


#Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT      Product.Product_Id AS Id, 
            Product.Product_Title AS Title, 
            Category.Category_Name AS Category_Title,
            Product.Unit_Price AS Price
	
FROM 		    Product, Category, Product_Category
            
WHERE 	    Product.Stock_Quantity > 0 AND
            Product.Product_Id = Product_Category.Product_Id AND
            Category.Category_Id = Product_Category.Category_Id
		
ORDER BY    Product.Issue_Date DESC;
        

#Display the list of products which don't have any images.
SELECT  Product.Product_Id AS Id,
        Product.Product_Title AS Title
		
FROM 		Product
WHERE 		Product.Product_Id NOT IN ( SELECT	Image.Product_Id
										FROM	Image );

/* Display all Id, Title and Parent Category Title for all the Categories listed, 
sorted by Parent Category Title and then Category Title. 
(If Category is top category then Parent Category Title column should display 
“Top Category” as value.)*/
SELECT	Category_Id AS Id,
		Category_Name AS Title,
        IF(Parent_Category = 0, 'Top Category', Category_Name) AS Parent_Category_Title
        
FROM	Category;
            
 
/*Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)*/
SELECT	Category_Id AS Id,
		Category_Name AS Title,
        Parent_Category AS Parent_Category_Title
        
FROM	Category
WHERE	Parent_Category = 0;
 
/*Display Product Title, Price & Description which falls into particular category Title 
(i.e. “Jeans”)*/
SELECT	Product.Product_Title AS Title,
		Product.Unit_Price AS Price,
		Product.Product_Description AS Description

FROM	Product, Product_Category, Category

WHERE	Product.Product_Id = Product_Category.Product_Id AND
		Category.Category_Id = Product_Category.Category_Id AND
        Category.Category_Name = 'Jeans';
    
/* Display the list of Products whose Quantity on hand (Inventory) is under 50*/
SELECT	*
FROM	Product
WHERE	Stock_Quantity < 50;

/*Increase the Inventory of all the products by 100.*/
UPDATE	Product
SET		Stock_Quantity = Stock_Quantity + 100
WHERE	Product_Id > 0;

# To check above query
SELECT * FROM Product;

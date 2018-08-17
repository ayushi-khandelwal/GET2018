USE StoreFront;

LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Category_Data.txt' INTO TABLE Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Category_Name,Parent_Category);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Product_Data.txt' INTO TABLE Product FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Title,Product_Description,Unit_Price,Stock_Quantity, Issue_Date);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/User_Data.txt' INTO TABLE User FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Name,User_Mail,Birth_Date,Contact_no);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Address_Data.txt' INTO TABLE Address FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Area,City,Zipcode,State,Country);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Image_Data.txt' INTO TABLE Image FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Id,Image_URL);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Login_Data.txt' INTO TABLE Login FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Password,User_Role,Last_Login);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Product_Category_Data.txt' INTO TABLE Product_Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Id,Category_Id);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Order_Data.txt' INTO TABLE Orders FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Order_Date,Order_Amount,Shipping_Address,Order_Status);
LOAD DATA INFILE 'D:/GET_ProjectAssignments2018/GET2018/DBMS/DBMS_Assignment_2/Data_Text_Files/Products_In_Order_Data.txt' INTO TABLE Products_In_Order FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Order_Id,Product_Id,Quantity,status);

#Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT product.Product_Id, product.Product_Title, product.Unit_Price, category.Category_Name, product.Issue_Date
FROM Product product, Product_Category productCategory, Category category
WHERE product.Product_Id = product.Product_Id AND productCategory.Category_Id = category.Category_ID AND product.Stock_Quantity > 0
ORDER BY product.Issue_Date DESC;

#Display the list of products which don't have any images.
SELECT DISTINCT product.Product_Title
FROM product product, Image image
WHERE NOT EXISTS (SELECT image.product_id 
                    FROM Image image
                    WHERE image.product_id = product.product_id);

/* Display all Id, Title and Parent Category Title for all the Categories listed, 
sorted by Parent Category Title and then Category Title. 
(If Category is top category then Parent Category Title column should display 
“Top Category” as value.)*/
SELECT parent.Category_Id, parent.Category_Name, parent.Parent_Category_Title
IF(parent.Parent_Category = 0, 'Top Category', child.Category_Name ) as parent.Parent_Category_Title
FROM Category parent
LEFT JOIN Category child
ON parent.Category_Id = child.Category_Id 
ORDER BY parent.Category_Name;

 
/*Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)*/
SELECT leaf.Category_Id, leaf.Category_Name, leaf.parent_Category
FROM Category leaf
WHERE leaf.parent_Category = 0;
 
/*Display Product Title, Price & Description which falls into particular category Title 
(i.e. “Whey Protein”)*/
SELECT product.Product_Title, product.unit_price, product.Product_Description
FROM Product product, Product_Category productCategory, Category category
WHERE product.Product_Id = productCategory.Product_Id AND
    productCategory.Category_Id = category.Category_Id AND
    category.Category_Name = "Whey Protein";
    
/* Display the list of Products whose Quantity on hand (Inventory) is under 50*/
SELECT product.Product_Title
FROM Product product
WHERE product.Stock_Quantity < 50;

/*Increase the Inventory of all the products by 100.*/
UPDATE Product 
SET Stock_Quantity = Stock_Quantity + 100 
WHERE product_id > 0;

SELECT * 
FROM Product product;

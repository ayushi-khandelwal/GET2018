package DBMS_Session_5.main;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import DBMS_Session_5.assignment_1.OrdersUtil;
import DBMS_Session_5.assignment_1.OrdersUtilPOJO;
import DBMS_Session_5.assignment_2.ImageUtil;
import DBMS_Session_5.assignment_3.ProductUtil;
import DBMS_Session_5.assignment_4.CategoryUtil;
import DBMS_Session_5.assignment_4.CategoryUtilPOJO;

public class JDBCSessionMain {
	public static void main (String args[]) {
		Scanner scanner = new Scanner(System.in);
		try {
			int choice = 0;
			while (choice <= 5) {
				System.out.println("Enter Your Choice:\n"
				        + "1. Get Order Information Of User\n"
				        + "2. Insert Batch Data in Image Table\n"
						+ "3. Delete Products Which are not ordered from one year\n"
						+ "4. Display Top Category Title with child counts\n"
						+ "5. EXIT");
				choice = scanner.nextInt();
				switch (choice) {
    				case 1:
    					OrdersUtil orderUtil = new OrdersUtil();
    					System.out.println("Enter user Id:");
    					List<OrdersUtilPOJO> resultList = orderUtil.getOrderDetailsOfUser(scanner.nextInt());
    					System.out.println("Number Of Records :" + resultList.size() + "\n");
    					
    					for (OrdersUtilPOJO value : resultList) {
                            			System.out.println("USER ID: " + value.getUserId());
    						System.out.println("ORDER ID: " + value.getOrderId());
    						System.out.println("ORDER DATE: " + value.getOrderDate());
    						System.out.println("ORDER AMOUNT: " + value.getOrderAmount());
    						System.out.println("-------------------------------------------------------\n");
    					}
    					OrdersUtilPOJO.emptyList();
    					break;
    				
    				case 2:
    					ImageUtil imageUtil = new ImageUtil();
    					System.out.println(imageUtil.insertBatchIntoImageTable() + " Rows added as batch !\n");
    					System.out.println("-------------------------------------------------------\n");
    					break;
    					
    				case 3:
    					ProductUtil productUtil = new ProductUtil();
    					System.out.println(productUtil.deleteProductsNotPurchased() + " Products Status Changed to Inactive !\n");
    					System.out.println("-------------------------------------------------------\n");
    					break;
    					
    				case 4:
    					CategoryUtil categoryUtil = new CategoryUtil();
    					List<CategoryUtilPOJO> list = categoryUtil.getChildCategoryCount();
    					for(CategoryUtilPOJO val : list){
    						System.out.println(val.getCategoryName() + "  " + val.getCategoryCount());
    					}
    					System.out.println("-------------------------------------------------------\n");					
    					break;
    					
    				case 5:
    					System.out.println("Program Terminated !");
    					System.exit(0);
    					
    				default:
    					System.out.println("Invalid choice entered !\n");
				}
			}
		} 
		catch (InputMismatchException e) {
			System.out.println("Entered Incorrect username format!! Try to give an integer input.");
		} 
		catch (SQLException se) {
			se.printStackTrace();
		}
		scanner.close();
	}
}

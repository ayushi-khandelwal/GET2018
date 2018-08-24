package DBMS_Session_5.assignment_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing results of OrderDetails
 */
public class CategoryUtilPOJO {
	private static List<CategoryUtilPOJO> resultList = new ArrayList<CategoryUtilPOJO>();
	
	private String categoryName;
	private int categoryCount;
	
	public CategoryUtilPOJO (String categoryName, int categoryCount) {
		this.categoryName = categoryName;
		this.categoryCount = categoryCount;
	}

	public static List<CategoryUtilPOJO> getResultList() {
		return resultList;
	}

	public static void addToResultList(CategoryUtilPOJO result) {
		resultList.add(result);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getCategoryCount() {
		return categoryCount;
	}

}

package DBMS.DBMS_Session_5.assignment_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing results of OrderDetails
 * Created on August 21, 2018
 */
public class CategoriesInParentCategoryPOJO {
	private static List<CategoriesInParentCategoryPOJO> resultList = new ArrayList<CategoriesInParentCategoryPOJO>();
	
	private String categoryName;
	private int categoryCount;
	
	public CategoriesInParentCategoryPOJO (String categoryName, int categoryCount) {
		this.categoryName = categoryName;
		this.categoryCount = categoryCount;
	}

	public static List<CategoriesInParentCategoryPOJO> getResultList() {
		return resultList;
	}

	public static void addToResultList(CategoriesInParentCategoryPOJO result) {
		resultList.add(result);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getCategoryCount() {
		return categoryCount;
	}

}

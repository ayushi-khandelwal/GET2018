package com.facade;


import java.util.List;

import com.dao.MYSQLCategoryDao;
import com.entity.Category;
import com.enums.Status;

public class CategoryFacade {
private static CategoryFacade categoryFacade = new CategoryFacade();
    
	MYSQLCategoryDao categoryDao = MYSQLCategoryDao.getInstance();
 
    public static CategoryFacade getInstance(){
    	return categoryFacade;
    }
    public Status insertCategory(String name){
    	if(categoryDao.insert(name)>0){
    		return Status.INSERTED;
    	}
    	else{
    		return Status.FAILED;
    	}
    }
    public List<Category> getAll(){
    	return categoryDao.getAll();
    }
    public Status updateName(String title,int id){
    	if(categoryDao.updateName(title, id)>0){
    		return Status.UPDATED;
    	}
    	else{
    		return Status.FAILED;
    	}
    	
    }
}

package com.facade;

import java.util.List;

import com.dao.MYSQLAdvertisementDao;
import com.entity.Advertisement;
import com.enums.Status;

public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();
    
	MYSQLAdvertisementDao advertisementDao = MYSQLAdvertisementDao.getInstance();
  
    
    public static AdvertisementFacade getInstance(){
    	return advertisementFacade;
    }


	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}
	
	public List<Advertisement> getAllById(int id) {
		return advertisementDao.getAllById(id);
	}
	public Status updateName(String name,int id){
		if(advertisementDao.updateName(name, id)>0){
			return Status.UPDATED;
		}
		else{
			return Status.FAILED;
		}
	}
	public Status deleteAdvertisementById(int id){
		if(advertisementDao.deleteById(id)>0){
			return Status.DELETED;
		}
		else{
			return Status.FAILED;
		}
	}
	public Status insertNewAdvertisement(Advertisement advertisement){
		if(advertisementDao.create(advertisement)>0){
			return Status.INSERTED;
		}
		else{
			return Status.FAILED;
		}
	}
}

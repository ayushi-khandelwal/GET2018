package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.UserRoles;
import com.metacube.training.repository.UserRolesRepository;

@Service
public class UserRolesServiceImplementaion implements UserRolesService {

	@Autowired
	private UserRolesRepository<UserRoles> userRolesRepository;
	
	@Override
	public UserRoles getUserRoleByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRolesRepository.findOne(userName);
	}

	@Override
	public boolean deleteUserRole(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserRole(UserRoles userRoles) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUserRoles(UserRoles userRoles) {
		// TODO Auto-generated method stub
		userRolesRepository.save(userRoles);
		return true;
	}

	@Override
	public List<UserRoles> getUserRoles() {
		// TODO Auto-generated method stub
		return userRolesRepository.findAll();
	}

	@Override
	public List<UserRoles> getUserRolesListByUserName(String username) {
		// TODO Auto-generated method stub
		return userRolesRepository.getUserRolesListByUserName(username);
	}
	
}

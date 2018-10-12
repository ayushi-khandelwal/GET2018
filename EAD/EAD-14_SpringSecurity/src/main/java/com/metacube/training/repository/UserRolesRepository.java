package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.UserRoles;

@Repository
@Transactional
public interface UserRolesRepository<p> extends JpaRepository<UserRoles, String>{

	@Query("FROM UserRoles where userName = :username")
	List<UserRoles> getUserRolesListByUserName(@Param("username") String username);
}

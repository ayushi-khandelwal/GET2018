package com.metacube.training.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	@Query("FROM Employee ORDER BY employeeCode DESC")
	List<Employee> getLatestEmployee();
	
	@Modifying
	@Query("UPDATE Employee SET firstName = :firstName, lastName = :lastName, dob = :dob, gender = :gender, primaryContactNumber = :primaryContactNumber,"
			+ "secondaryContactNumber = :secondaryContactNumber, emailId = :emailId, skypeId = :skypeId, profilePicture = :profilePicture, password = :password,"
			+ "enabled = :enabled WHERE employeeCode = :employeeCode")
	int updateEmployee(
			@Param("firstName") String firstName,
			@Param("lastName") String lastName,
			@Param("dob") Date dob,
			@Param("gender") String gender,
			@Param("primaryContactNumber") String primaryContactNumber,
			@Param("secondaryContactNumber") String secondaryContactNumber,
			@Param("emailId") String emailId,
			@Param("skypeId") String skypeId,
			@Param("profilePicture") String profilePicture,
			@Param("password") String password,
			@Param("enabled") boolean enabled,
			@Param("employeeCode") String employeeCode
			
	);
	
}

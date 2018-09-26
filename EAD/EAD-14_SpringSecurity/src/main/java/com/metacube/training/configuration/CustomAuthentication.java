package com.metacube.training.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.metacube.training.model.Employee;
import com.metacube.training.model.UserRoles;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.UserRolesService;

@Component
public class CustomAuthentication implements AuthenticationProvider {

	@Autowired
	UserRolesService userRolesService;

	@Autowired
	EmployeeService employeeService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
		String empCode = String.valueOf(auth.getPrincipal());
		String password = String.valueOf(auth.getCredentials());

		try {
			Employee employee = employeeService.getEmployeeById(empCode);

			if (!employee.getPassword().equals(password)) {

				throw new BadCredentialsException(
						"External system authentication failed");
			}
		} catch (Exception e) {

			throw new BadCredentialsException(
					"External system authentication failed");
		}

		/*
		 * if (!(employeeService.validateLogin(, password))) { throw new
		 * BadCredentialsException( "External system authentication failed"); }
		 */
		System.out.println("employee"
				+ employeeService.getEmployeeById(empCode));

		List<GrantedAuthority> roles = new ArrayList<>();
		
		List<UserRoles> roleList = userRolesService.getUserRolesListByUserName(empCode);

		for (UserRoles role : roleList) {
			System.out.println("role:" + role.getRole());
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return new UsernamePasswordAuthenticationToken(empCode, password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
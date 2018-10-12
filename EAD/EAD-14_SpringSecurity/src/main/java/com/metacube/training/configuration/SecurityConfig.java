package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.metacube.training")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private CustomAuthentication customAuthProvider;
    
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(customAuthProvider);
	}
	

	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		
		//(jdbc Authentication Code)
		 auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery(
		"select emp_code,password,enabled from employee where emp_code=?")
		.authoritiesByUsernameQuery(
		"select e.emp_code, r.role from user_roles r inner join employee e on r.user_name = e.emp_code"
		+ " where e.emp_code = ?");
		
		 // (In-Memory Authentication code)
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123456")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("E18/1000").password("{noop}123456")
				.roles("EMPLOYEE");

	}
	*/
	
	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
	 return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')")
				.antMatchers("/employee/*")
				.access("hasRole('ROLE_EMPLOYEE')")
				.and()
				.formLogin()
				. // login configuration
				loginPage("/login").loginProcessingUrl("/Login")
				.defaultSuccessUrl("/default").usernameParameter("username")
				.passwordParameter("password").and().logout()
				.logoutUrl("/logout")
				// logout configuration
				.logoutSuccessUrl("/login?logout").and().exceptionHandling()
				.accessDeniedPage("/error").and().csrf();

	}

}
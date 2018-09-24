package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @Autowired
	// DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		// auth.jdbcAuthentication().dataSource(dataSource)
		// .usersByUsernameQuery("select username,password,enabled from users where username=?")
		// .authoritiesByUsernameQuery("select username,role from user_roles where username=?");

		auth.inMemoryAuthentication().withUser("jitendra")
				.password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123456")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("E18/1000").password("{noop}123456")
				.roles("EMPLOYEE");

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
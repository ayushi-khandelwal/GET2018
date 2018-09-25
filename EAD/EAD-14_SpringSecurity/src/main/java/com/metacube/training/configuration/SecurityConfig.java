package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		 auth.jdbcAuthentication().dataSource(dataSource)
		 .usersByUsernameQuery("select username, password, enabled from users where username=?")
		 .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

/*		auth.inMemoryAuthentication().withUser("ayushi").password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("1").password("{noop}123456").roles("EMPLOYEE");*/

	}
	
    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
        builder.authenticationProvider(new CustomAuthenticationProvider());
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')")
            				    .antMatchers("/employee/*").access("hasRole('ROLE_EMPLOYEE')")
        				    .and()
                				.formLogin()
                				. // login configuration
                				loginPage("/login").loginProcessingUrl("/Login")
                				.defaultSuccessUrl("/default").usernameParameter("username")
                				.passwordParameter("password")
            				.and()
                				.logout()
                				.logoutUrl("/logout")
                				// logout configuration
                				.logoutSuccessUrl("/login?logout")
            				.and()
            				    .exceptionHandling()
        				        .accessDeniedPage("/error")
        			        .and()
        			            .csrf();

	}
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
    
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
        auth.setTargetUrlParameter("targetUrl");
        return auth;
    }   
}
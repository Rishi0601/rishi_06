package com.EmployeeMgmtUsingSpringMVCandThymeleaf.AppSecurity;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
//	InMemoryUserDetailsManager userDetailsManager(DataSource data) {
	UserDetailsManager userDetailsManager(DataSource data) {

//		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

//		jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password from usersnew where username=?");
//		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authoritiesnew where username=?");

		//UserDetails john = User.builder().username("john").password("{noop}123").roles("EMP").build();

		//UserDetails mary = User.builder().username("mary").password("{noop}123").roles("EMP", "MGR").build();

		//UserDetails adam = User.builder().username("adam").password("{noop}123").roles("EMP", "MGR", "ADM").build();
		 return new JdbcUserDetailsManager(data);
		//return new InMemoryUserDetailsManager(john, mary, adam);
	}

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				configurer -> configurer
				.requestMatchers("/employee").hasRole("EMPLOYEE")
				.requestMatchers("/manager").hasRole("MANAGER")
				.requestMatchers("/list").hasRole("ADMIN")
				.anyRequest()
				.authenticated())
				.formLogin(form -> form
						.loginPage("/loginpage")
						.defaultSuccessUrl("/employee/home", true)
						.loginProcessingUrl("/authenticateUser")
						.permitAll())
				.logout(logout -> logout
						.permitAll())
				.exceptionHandling(configurer -> configurer
						.accessDeniedPage("/accessdenied"));

		return http.build();
	}
}

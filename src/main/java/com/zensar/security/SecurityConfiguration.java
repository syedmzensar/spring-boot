package com.zensar.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {


	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
	}

	@Bean
	public UserDetailsService users() {
		UserBuilder users = User.withDefaultPasswordEncoder();
		UserDetails user = users
			.username("user")
			.password("user")
			.roles("USER")
			.build();
		UserDetails admin = users
			.username("admin")
			.password("admin")
			.roles("USER", "ADMIN")
			.build();
		
		//JDBC logic
		JdbcUserDetailsManager usersJdbc = new JdbcUserDetailsManager(dataSource());
		usersJdbc.createUser(user);
		usersJdbc.createUser(admin);
		
		System.out.println("========================>" + usersJdbc.getUsersByUsernameQuery());
		
		return usersJdbc;
	}

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService() {
	 * 
	 * @SuppressWarnings("deprecation") UserDetails user =
	 * User.withDefaultPasswordEncoder().username("user").password("user").roles(
	 * "USER") .username("admin").password("admin").roles("ADMIN") .build(); return
	 * new InMemoryUserDetailsManager(user);
	 * 
	 * }
	 */

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.antMatchers("/admin").hasRole("ADMIN").antMatchers("/user")
				.hasAnyRole("USER","ADMIN").antMatchers("/").permitAll().anyRequest().authenticated()).httpBasic()
				.and().formLogin();
		return http.build();
	}
	

}

package com.java.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		return httpSecurity
				.csrf(Customizer.withDefaults())
				 .authorizeHttpRequests((request)-> request.requestMatchers("/public").permitAll()
				 .requestMatchers("/adminOnly").hasRole("ADMIN")
				 .requestMatchers("/userOnly").hasRole("USER")
				 .anyRequest().authenticated())
				 .formLogin(Customizer.withDefaults())
				 .sessionManagement((session)-> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
				 .httpBasic(Customizer.withDefaults())				 
				 .build();
	}
	
	@Bean
	public UserDetailsService usersDetailsService() {
		UserDetails userOne = User.builder()
				.username("celene")
				.password("{noop}123")
				.roles("USER")
				.build();
		
		UserDetails userTwo = User.builder()
				.username("ruben")
				.password("{noop}123")
      			.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(userOne,userTwo);
	}

}

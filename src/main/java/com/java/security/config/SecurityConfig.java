package com.java.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
				 .authorizeHttpRequests((request)-> request.requestMatchers("/public").permitAll().anyRequest().authenticated())
				 .formLogin(Customizer.withDefaults())
				 .sessionManagement((session)-> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
				 .httpBasic(Customizer.withDefaults())
				 
				 .build();
	}

}

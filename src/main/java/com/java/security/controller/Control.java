package com.java.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Control {

	public Control() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/private")
	public String privateMethod(HttpServletRequest request) {
		return "esto es privado " + request.getSession().getId() ;
	}
	
	@GetMapping("/private1")
	public String privateMethod2() {
		return "esto es  ademas de privado";
	}
	
	@GetMapping("/public")
	public String publicMethod() {
		return "esto es  un metodo publico";
	}
	
}

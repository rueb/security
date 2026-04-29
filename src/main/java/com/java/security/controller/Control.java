package com.java.security.controller;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Control implements ErrorController{

	public Control() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/private")
	public String privateMethod(HttpServletRequest request) {
		return "esto es privado " + request.getSession().getId() ;
	}
	
	@RequestMapping("/error")
	public String handleError() {
	return "customError"; // Return the name of your error view
	}
	
	@GetMapping("/private1")
	public String privateMethod2() {
		return "esto es  ademas de privado";
	}
	
	@GetMapping("/public")
	public String publicMethod() {
		return "esto es  un metodo publico";
	}
	
	@GetMapping("/adminOnly")
	public String adminOnly() {
		return "este es  el ADMIN";
	}
	
	@GetMapping("/userOnly")
	public String usersOnly() {
		return "este es  el USER";
	}
	// https://www.youtube.com/watch?v=oBPnaC0AdKw
}

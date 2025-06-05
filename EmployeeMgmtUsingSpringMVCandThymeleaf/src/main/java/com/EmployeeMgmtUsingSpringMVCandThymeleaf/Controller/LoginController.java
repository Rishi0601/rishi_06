package com.EmployeeMgmtUsingSpringMVCandThymeleaf.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/loginpage")
	public String showLoginPage() {
		return "employee/login-page";
	}
	
	@GetMapping("/accessdenied")
	public String accesDenyHandler() {

		return "employee/access-denied";
		
}
}

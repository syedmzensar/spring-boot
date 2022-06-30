package test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden
public class HomeController {

	@GetMapping("/")
	public String sayHello() {
		return "<h1> Welcome to Spring Boot</h1>";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "<h1> Welcome to Admin dashboard</h1>";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "<h1> Welcome to User dashboard</h1>";
	}

}

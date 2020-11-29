package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@Autowired
	HelloService helloService;

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@PostMapping("hello")
	public String postHello(@RequestParam("id") int id,
			Model model) {
		
		Employee employee = helloService.findOne(id);
		
		model.addAttribute("employeeId", employee.getEmployeeId());
		model.addAttribute("employeeName", employee.getEmployeeName());
		model.addAttribute("employeeAge", employee.getAge());
		
		return "helloResponse";
	}
	
}

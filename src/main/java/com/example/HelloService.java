package com.example;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	@Autowired
	HelloRepository helloRepository;

	public Employee findOne(int id) {
		
		Map<String, Object> map = helloRepository.findOne(id);

		Employee employee = new Employee();
				
		employee.setEmployeeId((int)map.get("employee_id"));
		employee.setEmployeeName((String)map.get("employee_name"));
		employee.setAge((int)map.get("age"));
		
		return employee;
	}
	
}

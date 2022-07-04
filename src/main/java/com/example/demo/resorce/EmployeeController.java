package com.example.demo.resorce;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Credential;
import com.example.demo.model.Employee;
import com.example.demo.model.ServiceResponse;

import static com.example.demo.model.Credential.*;

import com.example.demo.repository.CredRepository;
import com.example.demo.repository.EmpRepository;
import com.example.demo.service.SequenceGeneratorService;

@RestController
public class EmployeeController {
	private @Autowired CredRepository credrepository;
	private @Autowired EmpRepository emprepository;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody Employee emp) {
		emprepository.save(emp);
		return "Added Employee with id: " + emp.getUser_Id();
	}
	@PostMapping("/generateEmployee")
	public String generateEmployee(@RequestBody Credential emp) {
		emp.setUserId(emp.getRole()+service.getSequenceNumber(SEQUENCE_NAME));
		credrepository.save(emp);
		return "Employee generated with id: "+emp.getUserId();
	}
	@PostMapping("/editEmployee")
	public String editEmployee(@RequestBody Employee emp)
	{
		emprepository.save(emp);
		return "Employee edited with id: "+emp.getUser_Id();
	}
	
	@GetMapping("/findAllemployee")
	public List<Employee> getemployees() {
		try {
		return (List<Employee>) emprepository.findAll();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/findAllemployeeCreds")
	public List<Credential> getemployeeCreds() {
		try {
			return (List<Credential>) credrepository.findAll();
		}
		catch (Exception e) {
			return null;
		}
	}
	@PostMapping("/loginCheck")
	public ServiceResponse check_login(@RequestBody Credential employee) {
		return employee.validateAuthentication(employee,credrepository);
	}	

	@GetMapping("/findAllemployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable String id) {
		
		return emprepository.findById(id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		credrepository.deleteById(id);
		emprepository.deleteById(id);
		return "Employee deleted with id : " + id;
	}
}

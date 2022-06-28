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
import com.example.demo.model.ServiceResponse;

import static com.example.demo.model.Credential.*;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.SequenceGeneratorService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/addEmployee")
	public String saveStudent(@RequestBody Credential student) {
		student.setUserId("EMPP"+service.getSequenceNumber(SEQUENCE_NAME));
		//student.setUserId("EMPP"+student.getId());
		repository.save(student);
		return "Added Employee with id : " + student.getUserId();
	}
	
	@GetMapping("/findAllemployee")
	public List<Credential> getBooks() {
		return repository.findAll();
	}
	@PostMapping("/loginCheck")
	public ServiceResponse check_login(@RequestBody Credential employee) {
		return employee.validateAuthentication(employee,repository);
	}	

	@GetMapping("/findAllemployee/{id}")
	public Optional<Credential> getBook(@PathVariable String id) {
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable String id) {
		repository.deleteById(id);
		return "Student deleted with id : " + id;
	}
}

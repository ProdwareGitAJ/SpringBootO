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

import com.example.demo.repository.CredRepository;
import com.example.demo.repository.EmpRepository;
import com.example.demo.service.SequenceGeneratorService;

@RestController
public class EmployeeController {
	@Autowired
	private CredRepository credrepository;
	//private EmpRepository emprepository;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody Credential emp) {
		emp.setUserId("EMPP"+service.getSequenceNumber(SEQUENCE_NAME));
		credrepository.save(emp);
		return "Added Employee with id : " + emp.getUserId();
	}
	
	@PostMapping("/editEmployee")
	public String editEmployee(@RequestBody Credential emp)
	{
		credrepository.save(emp);
		return "Employee edited with id: "+emp.getUserId();
	}
	
	@GetMapping("/findAllemployee")
	public List<Credential> getBooks() {
		return (List<Credential>) credrepository.findAll();
	}
	@PostMapping("/loginCheck")
	public ServiceResponse check_login(@RequestBody Credential employee) {
		return employee.validateAuthentication(employee,credrepository);
	}	

	@GetMapping("/findAllemployee/{id}")
	public Optional<Credential> getBook(@PathVariable String id) {
		
		return credrepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable String id) {
		credrepository.deleteById(id);
		return "Student deleted with id : " + id;
	}
}

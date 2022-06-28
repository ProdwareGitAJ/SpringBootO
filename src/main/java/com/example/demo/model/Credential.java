package com.example.demo.model;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.repository.EmployeeRepository;

import lombok.ToString;

@ToString

@Document(collection="Credential")
public class Credential {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	private String userId;
	private String passwd;
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public ServiceResponse validateAuthentication(Credential emp,EmployeeRepository repository) {
		Optional<Credential> user=repository.findById(emp.getUserId());
		
		ServiceResponse response = new ServiceResponse();
		if(user.isEmpty())
		{
			response.setApiStatus(false);
			response.setMessage("User credentials are empty");
		}
		else {
			Credential user1=user.get();
			if(user1.passwd.equals(emp.passwd))
			{
				response.setApiStatus(true);
				response.setMessage("Login Successful");
			}
			else {
				response.setApiStatus(false);
				response.setMessage("Invalid Password");
			}
		}
		return response;
	}	
	
}

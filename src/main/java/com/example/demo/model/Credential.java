package com.example.demo.model;

import java.util.Optional;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.repository.CredRepository;

import lombok.ToString;

@ToString

@Document(collection="Credential")
public class Credential {
	//variable for database reference 
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	//variables
	@Id
	private String userId;
	private String passwd;
	private String role;
	
	//getters and setters
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public ServiceResponse validateAuthentication(Credential emp,CredRepository repository) {
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

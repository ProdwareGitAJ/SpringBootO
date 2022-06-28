package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Credential;

public interface EmployeeRepository extends MongoRepository<Credential, String>{

}
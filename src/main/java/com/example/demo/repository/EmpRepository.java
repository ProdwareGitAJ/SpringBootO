package com.example.demo.repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Credential;

public interface EmpRepository extends CrudRepository<Credential, String>{

}
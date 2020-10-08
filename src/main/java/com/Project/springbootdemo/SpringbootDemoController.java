package com.Project.springbootdemo;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringbootDemoController {
	
//	@Autowired
//	private JAVAStudentDAO studentDAO = new JAVAStudentDAO() ;
	
	@Autowired
	private StudentRepo studentRepo;
	
	//Get all Students from the Arraylist
	@GetMapping(path="/jpa/getAllStudents")
	public List<Students> getAllStudents(){
		return studentRepo.findAll();		
	}
	
	//Adding a new student into the classroom
	@PostMapping(path="/jpa/addNewStudent")
	public ResponseEntity addNewStudent(@Valid @RequestBody Students newStudent){
		studentRepo.save(newStudent);
		
		return new ResponseEntity<>("Created new student",HttpStatus.CREATED);
	}
	@DeleteMapping(path="/jpa/deleteNewStudent/{id}")
	public ResponseEntity deleteNewStudent(@PathVariable Long id ){
		studentRepo.deleteById(id);
		
		return new ResponseEntity<>("Deleted User",HttpStatus.CREATED);
	}
	@PutMapping(path="/jpa/updatePassword/{id}")
	public java.util.Optional<Object> changePassword(@RequestBody Students newStudent, @PathVariable Long id) {
    return studentRepo.findById(id)
    	      .map(user -> {
    	        user.setPassword(newStudent.getPassword());
    	        return new ResponseEntity<>("Passsword updated successfully",HttpStatus.CREATED);
    	      });
	}
}

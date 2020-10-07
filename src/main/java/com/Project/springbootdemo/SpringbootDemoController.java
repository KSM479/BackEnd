package com.Project.springbootdemo;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringbootDemoController {
	
//	@Autowired
//	private JAVAStudentDAO studentDAO = new JAVAStudentDAO() ;
	
	@Autowired
	private StudentDAO studentService;
	
	//Get all Students from the Arraylist
	@GetMapping(path="getAllStudents")
	public  ArrayList<Students> getAllStudents(){
		 return studentService.displayStudents();		
	}
	
	//Adding a new student into the classroom
	@PostMapping(path="/addStudent")
	@ResponseStatus(HttpStatus.OK)
	public  void addStudent(Students newStudent){
		studentService.addUser(newStudent);
		
	}
	@PostMapping(path="/deleteStudent/{email}")
	@ResponseStatus(HttpStatus.OK)
	public  void deleteStudent(String email){
		studentService.deleteUser(email);
		
	}
	
	
}
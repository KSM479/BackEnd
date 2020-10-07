package com.Project.springbootdemo;


import java.util.ArrayList;


import org.springframework.stereotype.Component;

@Component
public class StudentDAO  {
	
	public static ArrayList<Students> StudentsData = new ArrayList<>();
	public StudentDAO() {
		StudentsData.add(new Students("deep","singh","kalpan.mehta@gmail.com","Kalpan)1234","Male",1,1,1934));
		StudentsData.add(new Students("kalpan","mehta","kmslf.mehta@gmail.com","Ka32)1234","Male",3,3,1966));
		
	}
	//Create / insert a User
	public void addUser(Students Students) {
		StudentsData.add(Students);
	}
	
	// Delete a user by it's email
	public void deleteUser(String email) {
		Students Students = findUser(email);
		if (Students == null) {
			return;
		}
		StudentsData.remove(Students);
		System.out.println("Now user is deleted \n");
	}
	
	// find first user by email. Return null if such user doesn't exist
	public Students findUser(String email) {
		for (int i = 0; i < StudentsData.size(); i++) {
			if (StudentsData.get(i).getEmail().equals(email)) {
				printUserInfo(StudentsData.get(i));
				return StudentsData.get(i);
			}
		}
		System.out.println("User does not exist.");
		return null;
	}
	
	// print a user information
	public void printUserInfo(Students Students) {
		System.out.println("User first name is: " + Students.getFirstName());
		System.out.println("User last name is: " + Students.getLastName());
		System.out.println("User birthday is: " + Students.getDay() + "/"+Students.getMonth() + "/"+ Students.getYear()  );
		System.out.println("User email is: " + Students.getEmail()); 
	}
	
	public ArrayList<Students> displayStudents(){
		return StudentsData;
	}
	
	
	public Object printAll() {
		System.out.println("Print all users : \n");
		for (int i = 0; i < StudentsData.size(); i++) {
			System.out.println("No." + (i + 1) + " user: ");
			printUserInfo(StudentsData.get(i));
			System.out.println("********");
		}
		System.out.println();
		return null;
	}
}
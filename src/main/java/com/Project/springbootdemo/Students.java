package com.Project.springbootdemo;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Students {
	
	@JsonIgnore  //filter this in response
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentID;
	
	@Size(min=1)
	private String name;
	
	@Size(min=1, message="Lastname should have more than one character")
	private String lastname;
	
	@Min(999)
	@Column(name="Telephone")
	private int phoneNumber;
	
	@Size(min=1)
	private String Email;
	@Size(min=1)
	private String Password;
	@Size(min=1)
	private String Gender;
	@Max(32)
	private int Day;
	
	@Max(13)
	private int Month;
	
	@Max(2020)
	private int Year;
	public Students() {

	}	
	public Students(String name, String lastname, int phoneNumber, String Email, String Password, int Day, int Month, int Year, String Gender) {
		super();
		setName(name);
		setLastname(lastname);
		setEmail(Email);
		setPassword(Password);
		setGender(Gender);
		setMonth(Month); setDay(Day); setYear(Year);
	
	}
	public String getGender() {
		return Gender;
	}
	public int getYear() {
		return Year;
	}
	public int getDay() {
		return Day;
	}
	
	public int getMonth() {
		return Month;
	}
	public int getStuendtID() {
		return studentID;
	}
	public void setGender(String gender) {
		gender = gender.toLowerCase();
	
		
		if(gender.equals("male") ||gender.equals("female")  ) {
			Gender = gender;
		}else {
			System.out.println("Enter a valid gender");
		}
	}
	public void setPassword(String password) {
		if(password.length()>=8) {
			int NumCount = 0;
			int SpecialCount = 0;
			for(int i=0;i<password.length();i++) {
				if(Character.isDigit(password.charAt(i))) {
					NumCount++;
				}
				if(!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i))) {
					SpecialCount++;
				}
			}
			if(Character.isUpperCase(password.charAt(0)) && NumCount > 0 && SpecialCount > 0) {
				Password = password;
			}else {
				System.out.println("The password must be 8 characters or longer with atleast 1 number, 1 special character and the first character must be uppercase");
			}
		}else {
			System.out.println("The password must be 8 characters or longer with atleast 1 number, 1 special character and the first character must be uppercase");
		}
	}

	public void setStuendtID(int stuendtID) {
		this.studentID = stuendtID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		int n = name.length();
		String str = name.replaceAll("[^a-zA-Z]","");
		int n1 = str.length();
		if(n==n1 && n!=0) {
			name = name;
		}else {
			System.out.println("Enter a valid name Ex:"+ name);
		}
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		
		if(lastname.length() > 2 && lastname != null && lastname.matches("^[a-zA-Z]*$")) {
			this.lastname = lastname;
			
				} else {
			System.out.println("Please enter a valid last name");
			
		}
	}
	
	public void setMonth(int month) {
		if(month >0 && month <=12) {
		Month = month;
		}else {
			System.out.println("Please Enter a valid month");
		}
	}
	
	public void setDay(int day) {
		if(day>=1 && day<=31) {
		Day = day;
		} else {
			System.out.println("Enter a valid day");
		}
	}
	
	public void setYear(int year) {
		if(year>=1903 && year<=2015) {
		Year = year;
		}else {
			System.out.println(" Enter a valid year");
		}
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pat = Pattern.compile(emailRegex);
		if(pat.matcher(email).matches() && email.length()!=0 ) {
		Email = email;
		}else {
			System.out.println("Enter a valid email address");
		}
	}
	@Override
	public String toString() {
		return "JAVAStudent [studentID=" + studentID + ", name=" + name + ", lastname=" + lastname + ", phoneNumber="
				+ phoneNumber + "]";
	}

	
	
}
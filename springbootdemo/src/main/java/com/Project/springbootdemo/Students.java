package com.Project.springbootdemo;

import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Students {
	
	
	@Size(min=1)
	private String FirstName;
	@Size(min=1, message="Lastname should have more than one character")
	private String LastName;
	private int Month;
	private int Day;
	private int Year;
	private String Gender;
	private String Email;
	private String Password;
	
	public Students() {
		
	}
	public Students (String firstName, 
		     String lastName, 
		     String emailAddress, 
		     String password,
		     String gender,
		     int Month, int Day, int Year) {
	setFirstName(firstName);
	setLastName(lastName);
	setEmail(emailAddress);
	setPassword(password);
	setGender(gender);
	setMonth(Month); setDay(Day); setYear(Year);
}
	public String getEmail() {
		return Email;
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

	public String getPassword() {
		return Password;
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

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		int n = firstName.length();
		String str = firstName.replaceAll("[^a-zA-Z]","");
		int n1 = str.length();
		if(n==n1 && n!=0) {
		FirstName = firstName;
		}else {
			System.out.println("Enter a valid name Ex:"+ FirstName);
		}
		
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		if(lastName.length() > 2 && lastName != null && lastName.matches("^[a-zA-Z]*$")) {
			this.LastName = lastName;
			
				} else {
			System.out.println("Please enter a valid last name");
			
		}
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		if(month >0 && month <=12) {
		Month = month;
		}else {
			System.out.println("Please Enter a valid month");
		}
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		if(day>=1 && day<=31) {
		Day = day;
		} else {
			System.out.println("Enter a valid day");
		}
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		if(year>=1903 && year<=2015) {
		Year = year;
		}else {
			System.out.println(" Enter a valid year");
		}
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		gender = gender.toLowerCase();
	
		
		if(gender.equals("male") ||gender.equals("female")  ) {
			Gender = gender;
		}else {
			System.out.println("Enter a valid gender");
		}
	}
	@Override
	public String toString() {
		return "User [emailID=" + Email + ", name=" + FirstName + ", lastname=" + LastName + "]";
	}
	}
	

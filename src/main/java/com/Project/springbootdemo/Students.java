package com.Project.springbootdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	
	public Students() {

	}
	public Students(String name, String lastname, int phoneNumber) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
	}
	
	public int getStuendtID() {
		return studentID;
	}
	public void setStuendtID(int stuendtID) {
		this.studentID = stuendtID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "JAVAStudent [studentID=" + studentID + ", name=" + name + ", lastname=" + lastname + ", phoneNumber="
				+ phoneNumber + "]";
	}

	
	
}
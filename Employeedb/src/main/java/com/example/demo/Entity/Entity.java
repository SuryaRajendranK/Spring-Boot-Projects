package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "ems")
public class Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empid;
	@Column(name = "first_name")
	private String firstname;
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	@Column(name = "last_name")
	private String lastname;
	@Column(name = "email_id", unique = true)
	private String email;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Entity(int empid ,String firstname, String lastname, String email) {
		super();
		this.empid=empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Entity() {

	}

	@Override
	public String toString() {
		return "Entity [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
}

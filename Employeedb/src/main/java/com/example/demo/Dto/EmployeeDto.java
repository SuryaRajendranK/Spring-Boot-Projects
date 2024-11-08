package com.example.demo.Dto;

public class EmployeeDto {
	private int empid;
	private String firstname;
	private String lastname;
	private String email;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeDto(int empid, String firstname, String lastname, String email) {
		super();
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	public EmployeeDto() {
		
	}
	@Override
	public String toString() {
		return "EmployeeDto [empid=" + empid + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + "]";
	}
	
	

}

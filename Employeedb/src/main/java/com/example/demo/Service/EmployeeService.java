package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.EmployeeDto;

import ch.qos.logback.core.joran.conditional.IfAction;

public interface EmployeeService {
	public EmployeeDto creatEmployeeDto(EmployeeDto employeeDto);
	//public EmployeeDto getemployeebyid(EmployeeDto employeeDto);
	public  EmployeeDto getemployeebyid(Integer id);
	//get all the employee details by id
	public List<EmployeeDto> getEmployeebyAll();
	// update the employee.here two parameter has passed for id is to check whether the employee is exists or not.employdto is passed to update the employee if exists
	EmployeeDto updateemployee(Integer id, EmployeeDto employeeDto);
	void deleteEmployee(Integer id);

}

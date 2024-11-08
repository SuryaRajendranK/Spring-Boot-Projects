package com.example.demo.Controller; 

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping("/api") 
public class EmployeeController {
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private EmployeeService employeeService;
	// REST API for adding employee
	@PostMapping("/addemp")
	public ResponseEntity<EmployeeDto> creatEmployeeDto(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedemp=employeeService.creatEmployeeDto(employeeDto);
		return new ResponseEntity<>(savedemp,HttpStatus.CREATED);
		
	}
	// REST API for getting single employee detail
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getemployeebyid(@PathVariable Integer id){
		EmployeeDto getemp=   employeeService.getemployeebyid(id);
		//return new ResponseEntity<>(getemp,HttpStatus.OK);
		return ResponseEntity.ok(getemp);
	}
	//REST API for getting all the employees
	@GetMapping("/getemp")
	public ResponseEntity<List<EmployeeDto>> getallemployee(){
		List<EmployeeDto> employee=employeeService.getEmployeebyAll();
		return ResponseEntity.ok(employee);
	}
	//REST API FOR UPDATE THE EMPLOYEE
	@PutMapping("/updateemp/{id}")
	public ResponseEntity<EmployeeDto> updateemploye(@PathVariable Integer id,@RequestBody EmployeeDto updateemployeeDto){
		EmployeeDto dto=employeeService.updateemployee(id, updateemployeeDto);
		return ResponseEntity.ok(dto);
		
		
	}
	//Rest api for delete the employee
	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employee deleted Sucessfully");
		
	}

}

package com.example.demo.Mapper;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.Entity.Entity;

public class EmployeeMapper {
	//entity to employeedto
	public static EmployeeDto mapToEmployeeDto(Entity entity) {
		return new EmployeeDto(
				entity.getEmpid(),
				entity.getFirstname(),
				entity.getLastname(),
				entity.getEmail()
				);
	}
	//employeedto to entity
	public static Entity mapToEntity(EmployeeDto employeeDto) {
		return new Entity(
				employeeDto.getEmpid(),
				employeeDto.getFirstname(),
				employeeDto.getLastname(),
				employeeDto.getEmail()
				);
			
		
	}

}

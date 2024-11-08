package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.EmployeeDto;
import com.example.demo.Entity.Entity;
import com.example.demo.Mapper.EmployeeMapper;
import com.example.demo.Repositary.EmployeeRepo;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		
		this.employeeRepo = employeeRepo;
	}


	private EmployeeRepo employeeRepo;
	
	@Override
	public EmployeeDto creatEmployeeDto(EmployeeDto employeeDto) {
		//we need to map employeedto to entity class because of storing data.data storeing is done with the help of entity class.entity class field is same as the database fields
		Entity entity=EmployeeMapper.mapToEntity(employeeDto);
		//after converting to entity we need to save the data to the database
		Entity savedEntity=employeeRepo.save(entity);
		//saved entity convert to employeedto .using dto class the responce sends back to the client
		return EmployeeMapper.mapToEmployeeDto(savedEntity);
	}

	@Override
	public EmployeeDto getemployeebyid(Integer id) {
		Entity entity=employeeRepo.findById(id ).orElseThrow(()->
		new ResourceNotFoundException("Employee not found:"+id));
		return EmployeeMapper.mapToEmployeeDto(entity);
	}

	@Override
	public List<EmployeeDto> getEmployeebyAll() {
		List<Entity> entity=  employeeRepo.findAll();
		return entity.stream().map((emp) -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateemployee(Integer id, EmployeeDto employeeDto) {
	 Entity employee=employeeRepo.findById(id).orElseThrow(()->
	 new ResourceNotFoundException("employee not found with exists id"+id));
	 
	 employee.setFirstname(employeeDto.getFirstname());
	 employee.setLastname(employeeDto.getLastname());
	 employee.setEmail(employeeDto.getEmail());
	Entity updateeEntity= employeeRepo.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updateeEntity);
	}

	@Override
	public void deleteEmployee(Integer id) {
		 Entity employee=employeeRepo.findById(id).orElseThrow(()->
		 new ResourceNotFoundException("employee not found with exists id"+id));
		 employeeRepo.deleteById(id);
		
	}
}

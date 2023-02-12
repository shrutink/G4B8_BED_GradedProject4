package com.greatlearning.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.security.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee saveEmployee(Employee student);

	Employee getEmployeeById(Long id);

	Employee updateemployee(Employee student);

	String deleteEmployeeById(Long id);

	List<Employee> getEmployeesWithFname(String fname);

	List<Employee> getEmployeesCustomSortedByFname(Direction direction);

}
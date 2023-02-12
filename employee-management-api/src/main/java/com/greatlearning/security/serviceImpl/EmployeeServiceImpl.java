package com.greatlearning.security.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.security.entity.Employee;
import com.greatlearning.security.repository.EmployeeRepository;
import com.greatlearning.security.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateemployee(Employee student) {
		return employeeRepository.save(student);
	}

	@Override
	public String deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		return "Deleted Employee id -" + id + "";

	}

	@Override
	public List<Employee> getEmployeesWithFname(String fname) {
		Employee employeeWithTheseName = new Employee();
		employeeWithTheseName.setFirstname(fname);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstname", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastname", "email");
		Example<Employee> example = Example.of(employeeWithTheseName, exampleMatcher);
		return employeeRepository.findAll(example);
	}

	@Override
	public List<Employee> getEmployeesCustomSortedByFname(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstname"));
	}

}

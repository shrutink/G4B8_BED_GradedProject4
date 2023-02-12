package com.greatlearning.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.security.entity.Employee;
import com.greatlearning.security.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getAEmployeeById")
	public Employee getEmployeeByIdById(Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/addEmployee")
	public Employee createEmployee(Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeById(Long id) {

		return employeeService.deleteEmployeeById(id);
	}

	@GetMapping("/findEmployeesWithFname")
	public List<Employee> getEmployeesWithFname(String fname) {
		return employeeService.getEmployeesWithFname(fname);
	}

	@GetMapping("/getEmployeesCustomSortedByFname")
	public List<Employee> getLibrariesCustomSortedByName(Direction direction) {
		return employeeService.getEmployeesCustomSortedByFname(direction);
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(Employee employee) {
		return employeeService.saveEmployee(employee);
	}
}

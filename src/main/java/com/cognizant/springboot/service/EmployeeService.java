package com.cognizant.springboot.service;

import java.util.List;

import com.cognizant.springboot.model.Employee;


public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long Id);
}

package com.nagarro.dao;

import java.util.List;

import com.nagarro.dto.Employee;
public interface EmployeeDao {
	List<Employee> getAllEmployees();

	void addAllEmployees(List<Employee> employees);

	void updateEmployee(Employee employee);

	void addEmployee(Employee employee);
}

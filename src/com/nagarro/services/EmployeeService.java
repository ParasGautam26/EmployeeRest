package com.nagarro.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.dto.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	void addAllEmployees(MultipartFile file);

	void updateEmployee(Employee employee);

	void addEmployeeDetailsToFile(ICsvBeanWriter csvBeanWriter) throws IOException;

}
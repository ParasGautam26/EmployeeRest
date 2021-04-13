package com.nagarro.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.nagarro.constant.Constant;
import com.nagarro.dao.EmployeeDao;
import com.nagarro.dto.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees;
		String url = Constant.REST_URL + Constant.GET_ALL_EMPLOYEES;
		ResponseEntity<List<Employee>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		employees = response.getBody();
		return employees;
	}

	@Override
	public void addEmployee(Employee employee) {
		String url = Constant.REST_URL + Constant.POST_EMPLOYEE;
		restTemplate.postForObject(url, employee, Employee.class);
	}

	@Override
	public void addAllEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			this.addEmployee(employee);
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		String url = Constant.REST_URL + Constant.PUT_EMPLOYEE;
		restTemplate.put(url, employee);
	}
}
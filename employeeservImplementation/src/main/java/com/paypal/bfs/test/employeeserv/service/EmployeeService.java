package com.paypal.bfs.test.employeeserv.service;

import java.util.List;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee createEmployee(Employee employee);

}

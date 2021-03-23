package com.paypal.bfs.test.employeeserv.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) {

		Employee employee = new Employee();
		employee.setId(Integer.valueOf(id));
		employee.setFirstName("BFS");
		employee.setLastName("Developer");
		employee.setDateOfBirth(new Date());

		Address address = new Address();
		address.setLine1("line 1");
		address.setLine2("line 2");
		address.setCity("city");
		address.setCountry("country");
		address.setZipCode("zip code");
		employee.setAddress(address);

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> createEployee(Employee newEmployee) {
		return new ResponseEntity<Employee>(employeeService.createEmployee(newEmployee), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
}

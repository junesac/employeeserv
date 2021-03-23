package com.paypal.bfs.test.employeeserv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeUtil util;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp -> employees.add(getEmployee(emp)));
		return employees;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		util.validate(employee);
		EmployeeEntity empEnttity = employeeRepository.save(getEmployeeEntity(employee));
		return getEmployee(empEnttity);
	}

	private Employee getEmployee(EmployeeEntity emp) {

		Address address = new Address();
		AddressEntity addE = emp.getAddress();
		address.setLine1(addE.getLine1());
		address.setLine2(addE.getLine2());
		address.setCity(addE.getCity());
		address.setCountry(addE.getCountry());
		address.setZipCode(addE.getZip_code());

		Employee employee = new Employee();
		employee.setId(new Long(emp.getId()).intValue());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setDateOfBirth(emp.getDateOfBirth());
		employee.setAddress(address);
		return employee;
	}

	private EmployeeEntity getEmployeeEntity(Employee emp) {

		Address address = emp.getAddress();
		AddressEntity addressE = new AddressEntity(address.getLine1(), address.getLine2(), address.getCity(),
				address.getCountry(), address.getZipCode());

		EmployeeEntity employee = new EmployeeEntity(emp.getFirstName(), emp.getLastName(), emp.getDateOfBirth(),
				addressE);

		return employee;
	}

}

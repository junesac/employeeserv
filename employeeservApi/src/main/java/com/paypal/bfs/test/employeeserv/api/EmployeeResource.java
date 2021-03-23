package com.paypal.bfs.test.employeeserv.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

	/**
	 * Retrieves the {@link Employee} resource by id.
	 *
	 * @param id
	 *            employee id.
	 * @return {@link Employee} resource.
	 */
	@RequestMapping("/v1/bfs/employees/{id}")
	ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

	// ----------------------------------------------------------
	// TODO - add a new operation for creating employee resource.
	// ----------------------------------------------------------

	@PostMapping(path = "/v1/bfs/employees/create", consumes = "application/json", produces = "application/json")
	ResponseEntity<Employee> createEployee(@RequestBody Employee newEmployee);

	@RequestMapping("/v1/bfs/employees/get")
	ResponseEntity<List<Employee>> getAllEmployees();

}

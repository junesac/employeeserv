package com.paypal.bfs.test.employeeserv.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	List<EmployeeEntity> findByFirstNameAndLastName(String firstName, String lastName);
}

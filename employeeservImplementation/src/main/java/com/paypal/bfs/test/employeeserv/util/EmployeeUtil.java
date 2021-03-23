package com.paypal.bfs.test.employeeserv.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.DuplicateRecordException;
import com.paypal.bfs.test.employeeserv.exception.RequiredFieldsMissingException;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;

@Service
public class EmployeeUtil {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void validate(Employee newEmployee) {
		validateMissingFields(newEmployee);
		validateDuplicateRecords(newEmployee);
	}

	private void validateDuplicateRecords(Employee newEmployee) {
		List<EmployeeEntity> result = employeeRepository.findByFirstNameAndLastName(newEmployee.getFirstName(),
				newEmployee.getLastName());
		if (result.size() > 0) {
			throw new DuplicateRecordException("Record with given first name & last name already exists");
		}
	}

	private void validateMissingFields(Employee newEmployee) {
		if (newEmployee.getFirstName() == null) {
			throw new RequiredFieldsMissingException("First name is missing");
		}

		if (newEmployee.getLastName() == null) {
			throw new RequiredFieldsMissingException("Last name is missing");
		}

		if (newEmployee.getDateOfBirth() == null) {
			throw new RequiredFieldsMissingException("Date of birth is missing");
		}

		Address address = newEmployee.getAddress();
		if (address.getLine1() == null) {
			throw new RequiredFieldsMissingException("Line 1 is missing");
		}

		if (address.getCity() == null) {
			throw new RequiredFieldsMissingException("City in Address field is missing");
		}

		if (address.getCountry() == null) {
			throw new RequiredFieldsMissingException("Country in Address field is missing");
		}

		if (address.getZipCode() == null) {
			throw new RequiredFieldsMissingException("ZIp Code in Address field is missing");
		}
	}

	public Employee getEmployee(EmployeeEntity emp) {

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

	public EmployeeEntity getEmployeeEntity(Employee emp) {

		Address address = emp.getAddress();
		AddressEntity addressE = new AddressEntity(address.getLine1(), address.getLine2(), address.getCity(),
				address.getCountry(), address.getZipCode());

		EmployeeEntity employee = new EmployeeEntity(emp.getFirstName(), emp.getLastName(), emp.getDateOfBirth(),
				addressE);

		return employee;
	}

}

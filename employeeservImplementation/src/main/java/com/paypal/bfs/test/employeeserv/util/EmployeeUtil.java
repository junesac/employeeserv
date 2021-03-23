package com.paypal.bfs.test.employeeserv.util;

import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.RequiredFieldsMissingException;

@Service
public class EmployeeUtil {

	public void validate(Employee newEmployee) {

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

}

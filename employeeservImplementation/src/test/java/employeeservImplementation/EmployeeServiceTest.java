package employeeservImplementation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.entities.AddressEntity;
import com.paypal.bfs.test.employeeserv.entities.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.impl.EmployeeServiceImpl;
import com.paypal.bfs.test.employeeserv.util.EmployeeUtil;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private EmployeeUtil util;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	public void testGetAllEmployees() {

		List<EmployeeEntity> expected = new ArrayList<>();
		EmployeeEntity empE = new EmployeeEntity("first name", "last name", new Date(),
				new AddressEntity("line1", null, "city", "country", "zip code"));
		expected.add(empE);

		Address address = new Address();
		AddressEntity addE = empE.getAddress();
		address.setLine1(addE.getLine1());
		address.setLine2(addE.getLine2());
		address.setCity(addE.getCity());
		address.setCountry(addE.getCountry());
		address.setZipCode(addE.getZip_code());

		Employee employee = new Employee();
		employee.setId(new Long(empE.getId()).intValue());
		employee.setFirstName(empE.getFirstName());
		employee.setLastName(empE.getLastName());
		employee.setDateOfBirth(empE.getDateOfBirth());
		employee.setAddress(address);

		Mockito.when(employeeRepository.findAll()).thenReturn(expected);
		Mockito.when(util.getEmployee(empE)).thenReturn(employee);

		List<Employee> actual = employeeService.getAllEmployees();
		assertEquals(expected.size(), actual.size());
		assertEquals(expected.get(0).getFirstName(), actual.get(0).getFirstName());
		assertEquals(expected.get(0).getLastName(), actual.get(0).getLastName());
		assertEquals(expected.get(0).getDateOfBirth(), actual.get(0).getDateOfBirth());

		assertEquals(expected.get(0).getAddress().getCity(), actual.get(0).getAddress().getCity());
		assertEquals(expected.get(0).getAddress().getLine1(), actual.get(0).getAddress().getLine1());
		assertEquals(expected.get(0).getAddress().getLine2(), actual.get(0).getAddress().getLine2());
		assertEquals(expected.get(0).getAddress().getCountry(), actual.get(0).getAddress().getCountry());
		assertEquals(expected.get(0).getAddress().getZip_code(), actual.get(0).getAddress().getZipCode());

	}

	@Test
	public void test() {

		EmployeeEntity empE = new EmployeeEntity("first name", "last name", new Date(),
				new AddressEntity("line1", null, "city", "country", "zip code"));

		Address address = new Address();
		AddressEntity addE = empE.getAddress();
		address.setLine1(addE.getLine1());
		address.setLine2(addE.getLine2());
		address.setCity(addE.getCity());
		address.setCountry(addE.getCountry());
		address.setZipCode(addE.getZip_code());

		Employee employee = new Employee();
		employee.setId(new Long(empE.getId()).intValue());
		employee.setFirstName(empE.getFirstName());
		employee.setLastName(empE.getLastName());
		employee.setDateOfBirth(empE.getDateOfBirth());
		employee.setAddress(address);

		Mockito.when(util.getEmployeeEntity(employee)).thenReturn(empE);
		Mockito.when(util.getEmployee(empE)).thenReturn(employee);
		Mockito.when(employeeRepository.save(empE)).thenReturn(empE);

		Employee actual = employeeService.createEmployee(employee);

		assertEquals(employee.getFirstName(), actual.getFirstName());
		assertEquals(employee.getLastName(), actual.getLastName());
		assertEquals(employee.getDateOfBirth(), actual.getDateOfBirth());

		assertEquals(employee.getAddress().getCity(), actual.getAddress().getCity());
		assertEquals(employee.getAddress().getLine1(), actual.getAddress().getLine1());
		assertEquals(employee.getAddress().getLine2(), actual.getAddress().getLine2());
		assertEquals(employee.getAddress().getCountry(), actual.getAddress().getCountry());
		assertEquals(employee.getAddress().getZipCode(), actual.getAddress().getZipCode());

	}
}

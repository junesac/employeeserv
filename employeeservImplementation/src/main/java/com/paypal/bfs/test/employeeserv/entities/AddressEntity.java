package com.paypal.bfs.test.employeeserv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class AddressEntity {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String line1;

	@Column(nullable = false)
	private String line2;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String zip_code;

	@OneToOne(mappedBy = "address")
	private EmployeeEntity employeeEntity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	@Override
	public String toString() {
		return "AdressEntity [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", country="
				+ country + ", zip_code=" + zip_code + ", employeeEntity=" + employeeEntity + "]";
	}

	public AddressEntity() {

	}

	public AddressEntity(String line1, String line2, String city, String country, String zip_code) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.country = country;
		this.zip_code = zip_code;
	}

}
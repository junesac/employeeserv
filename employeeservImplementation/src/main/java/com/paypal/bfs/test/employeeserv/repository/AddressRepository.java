package com.paypal.bfs.test.employeeserv.repository;

import org.springframework.data.repository.CrudRepository;

import com.paypal.bfs.test.employeeserv.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}

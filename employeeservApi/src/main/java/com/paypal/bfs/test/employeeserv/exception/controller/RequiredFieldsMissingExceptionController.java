package com.paypal.bfs.test.employeeserv.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.paypal.bfs.test.employeeserv.exception.RequiredFieldsMissingException;

@ControllerAdvice
public class RequiredFieldsMissingExceptionController {
	@ExceptionHandler(value = RequiredFieldsMissingException.class)
	public ResponseEntity<Object> exception(RequiredFieldsMissingException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
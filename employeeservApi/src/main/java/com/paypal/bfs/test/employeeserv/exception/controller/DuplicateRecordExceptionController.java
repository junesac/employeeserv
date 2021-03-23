package com.paypal.bfs.test.employeeserv.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.paypal.bfs.test.employeeserv.exception.DuplicateRecordException;

@ControllerAdvice
public class DuplicateRecordExceptionController {
	@ExceptionHandler(value = DuplicateRecordException.class)
	public ResponseEntity<Object> exception(DuplicateRecordException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.PRECONDITION_FAILED);
	}
}
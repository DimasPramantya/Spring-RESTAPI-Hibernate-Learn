package com.example.dimaspramantya.springrestcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.dimaspramantya.springrestcrud.entity.Employee;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exc.getMessage());
		errorResponse.setStatus("Error");
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
}

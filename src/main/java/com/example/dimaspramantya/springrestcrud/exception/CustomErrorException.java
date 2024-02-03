package com.example.dimaspramantya.springrestcrud.exception;

import org.springframework.http.HttpStatus;

public class CustomErrorException extends RuntimeException{
	public ErrorResponse response = new ErrorResponse();
	private HttpStatus httpStatus;
	
	public CustomErrorException(String message, Throwable cause,
			String status, HttpStatus httpStatus, long timeStamps) {
		super(cause);
		this.response = new ErrorResponse(status, message, timeStamps);
		this.httpStatus = httpStatus;
	}

	public CustomErrorException(String message,
			String status, HttpStatus httpStatus, long timeStamps) {
		this.response = new ErrorResponse(status, message, timeStamps);
		this.httpStatus = httpStatus;
	}
	
	public CustomErrorException(String message) {
		this.response.message = message;
	}

	public String getStatus() {
		return this.response.status;
	}

	public void setStatus(String status) {
		this.response.status = status;
	}

	public HttpStatus getStatusCode() {
		return this.httpStatus;
	}

	public void setStatusCode(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public long getTimeStamps() {
		return this.response.timeStamp;
	}
	
	public void setTimeStamps(long timeStamp) {
		this.response.timeStamp = timeStamp;
	}
}

package com.example.dimaspramantya.springrestcrud.exception;

public class ErrorResponse {
	public String status;
	public String message;
	public long timeStamp;
	
	public ErrorResponse() {
		
	}
	
	public ErrorResponse(String status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
}
